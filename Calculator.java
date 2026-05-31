import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * A sleek dark-themed GUI Calculator built with Java Swing.
 *
 * Compile : javac Calculator.java
 * Run     : java Calculator
 */
public class Calculator extends JFrame {

    // ── State ──────────────────────────────────────────────────────────
    private String  expression = "";
    private boolean newNumber  = true;

    // ── Display ────────────────────────────────────────────────────────
    private final JLabel subDisplay;
    private final JLabel mainDisplay;

    // ── Palette ────────────────────────────────────────────────────────
    private static final Color BG_OUTER   = new Color(0x1a, 0x1a, 0x2e);
    private static final Color BG_DISPLAY = new Color(0x16, 0x21, 0x3e);
    private static final Color C_NUM      = new Color(0x2d, 0x35, 0x61);
    private static final Color C_OP       = new Color(0xe9, 0x45, 0x60);
    private static final Color C_FUNC     = new Color(0x25, 0x35, 0x55);
    private static final Color C_EQUAL    = new Color(0x0f, 0x34, 0x60);
    private static final Color FG_MAIN    = new Color(0xe2, 0xe8, 0xf0);
    private static final Color FG_SUB     = new Color(0x6c, 0x7a, 0x9c);
    private static final Color FG_FUNC    = new Color(0xa0, 0xb4, 0xd0);

    // ── Constructor ────────────────────────────────────────────────────
    public Calculator() {
        setTitle("Java Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(380, 620);
        setLocationRelativeTo(null);
        getContentPane().setBackground(BG_OUTER);
        setLayout(new BorderLayout(0, 0));

        // ── Display panel ──────────────────────────────────────────────
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        displayPanel.setBackground(BG_DISPLAY);
        displayPanel.setBorder(new EmptyBorder(14, 18, 14, 18));

        subDisplay = new JLabel(" ", SwingConstants.RIGHT);
        subDisplay.setFont(new Font("Courier New", Font.PLAIN, 14));
        subDisplay.setForeground(FG_SUB);
        subDisplay.setAlignmentX(Component.RIGHT_ALIGNMENT);
        subDisplay.setMaximumSize(new Dimension(Integer.MAX_VALUE, 22));

        mainDisplay = new JLabel("0", SwingConstants.RIGHT);
        mainDisplay.setFont(new Font("Courier New", Font.BOLD, 40));
        mainDisplay.setForeground(FG_MAIN);
        mainDisplay.setAlignmentX(Component.RIGHT_ALIGNMENT);
        mainDisplay.setMaximumSize(new Dimension(Integer.MAX_VALUE, 58));

        displayPanel.add(subDisplay);
        displayPanel.add(Box.createVerticalStrut(6));
        displayPanel.add(mainDisplay);

        add(displayPanel, BorderLayout.NORTH);

        // ── Button area ────────────────────────────────────────────────
        JPanel btnArea = new JPanel(new GridLayout(5, 1, 0, 6));
        btnArea.setBackground(BG_OUTER);
        btnArea.setBorder(new EmptyBorder(8, 10, 12, 10));

        // Rows 0-3: simple 4-column grids
        String[][] rows = {
            {"C", "±", "%", "÷"},
            {"7", "8", "9", "×"},
            {"4", "5", "6", "−"},
            {"1", "2", "3", "+"},
        };
        Color[][] colors = {
            {C_OP,   C_FUNC, C_FUNC, C_OP},
            {C_NUM,  C_NUM,  C_NUM,  C_OP},
            {C_NUM,  C_NUM,  C_NUM,  C_OP},
            {C_NUM,  C_NUM,  C_NUM,  C_OP},
        };

        for (int r = 0; r < 4; r++) {
            JPanel row = new JPanel(new GridLayout(1, 4, 6, 0));
            row.setBackground(BG_OUTER);
            for (int c = 0; c < 4; c++) {
                row.add(makeBtn(rows[r][c], colors[r][c]));
            }
            btnArea.add(row);
        }

        // Row 4: "0" is double-wide
        JPanel lastRow = new JPanel(new GridBagLayout());
        lastRow.setBackground(BG_OUTER);
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill    = GridBagConstraints.BOTH;
        gc.weighty = 1.0;
        gc.insets  = new Insets(0, 0, 0, 3);

        gc.gridx = 0; gc.weightx = 2.0; gc.gridwidth = 1;
        lastRow.add(makeBtn("0", C_NUM), gc);

        gc.gridx = 1; gc.weightx = 1.0; gc.insets = new Insets(0, 3, 0, 3);
        lastRow.add(makeBtn(".", C_NUM), gc);

        gc.gridx = 2; gc.insets = new Insets(0, 3, 0, 0);
        lastRow.add(makeBtn("=", C_EQUAL), gc);

        btnArea.add(lastRow);
        add(btnArea, BorderLayout.CENTER);

        // ── Keyboard ───────────────────────────────────────────────────
        addKeyListener(new KeyAdapter() {
            @Override public void keyPressed(KeyEvent e) { handleKey(e); }
        });
        setFocusable(true);
        requestFocusInWindow();

        setVisible(true);
    }

    // ── Button factory ─────────────────────────────────────────────────
    private JButton makeBtn(String label, Color bg) {
        JButton btn = new JButton(label);
        btn.setFont(new Font("Courier New", Font.BOLD, 20));
        btn.setBackground(bg);
        Color fg = (label.equals("±") || label.equals("%")) ? FG_FUNC : Color.WHITE;
        btn.setForeground(fg);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Color hover = bg.darker();
        btn.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) { btn.setBackground(hover); }
            @Override public void mouseExited (MouseEvent e) { btn.setBackground(bg);    }
        });
        btn.addActionListener(e -> handleInput(label));
        return btn;
    }

    // ── Input dispatch ─────────────────────────────────────────────────
    private void handleInput(String t) {
        switch (t) {
            case "C"                      -> clear();
            case "±"                      -> negate();
            case "%"                      -> percent();
            case "="                      -> evaluate();
            case "+","−","×","÷"          -> inputOp(t);
            default                       -> inputDigit(t);
        }
    }

    private void inputDigit(String d) {
        String cur = mainDisplay.getText();
        if (d.equals(".") && !newNumber && cur.contains(".")) return;
        if (newNumber) {
            mainDisplay.setText(d.equals(".") ? "0." : d);
            newNumber = false;
        } else {
            mainDisplay.setText(cur.equals("0") && !d.equals(".") ? d : cur + d);
        }
    }

    private void inputOp(String op) {
        expression += mainDisplay.getText() + " " + op + " ";
        subDisplay.setText(expression);
        newNumber = true;
    }

    private void evaluate() {
        String cur  = mainDisplay.getText();
        String full = expression + cur;
        subDisplay.setText(full + " =");
        try {
            double result = eval(full);
            mainDisplay.setText(fmt(result));
        } catch (ArithmeticException ex) {
            mainDisplay.setText("÷0 Error");
        } catch (Exception ex) {
            mainDisplay.setText("Error");
        }
        expression = "";
        newNumber  = true;
    }

    private void clear() {
        expression = "";
        mainDisplay.setText("0");
        subDisplay.setText(" ");
        newNumber = true;
    }

    private void negate() {
        try { mainDisplay.setText(fmt(-Double.parseDouble(mainDisplay.getText()))); }
        catch (NumberFormatException ignored) {}
    }

    private void percent() {
        try { mainDisplay.setText(fmt(Double.parseDouble(mainDisplay.getText()) / 100.0)); }
        catch (NumberFormatException ignored) {}
    }

    // ── Recursive-descent expression evaluator ─────────────────────────
    private int    ePos;
    private String eStr;

    private double eval(String raw) {
        eStr = raw.replace("÷","/").replace("×","*").replace("−","-").replaceAll("\\s+","");
        ePos = 0;
        double v = addSub();
        if (ePos != eStr.length()) throw new RuntimeException("Parse error");
        return v;
    }

    private double addSub() {
        double v = mulDiv();
        while (ePos < eStr.length()) {
            char op = eStr.charAt(ePos);
            if      (op == '+') { ePos++; v += mulDiv(); }
            else if (op == '-') { ePos++; v -= mulDiv(); }
            else break;
        }
        return v;
    }

    private double mulDiv() {
        double v = unary();
        while (ePos < eStr.length()) {
            char op = eStr.charAt(ePos);
            if (op == '*') { ePos++; v *= unary(); }
            else if (op == '/') {
                ePos++;
                double d = unary();
                if (d == 0) throw new ArithmeticException("div0");
                v /= d;
            } else break;
        }
        return v;
    }

    private double unary() {
        if (ePos < eStr.length() && eStr.charAt(ePos) == '-') { ePos++; return -unary(); }
        return number();
    }

    private double number() {
        int start = ePos;
        while (ePos < eStr.length() && (Character.isDigit(eStr.charAt(ePos)) || eStr.charAt(ePos) == '.')) ePos++;
        if (start == ePos) throw new RuntimeException("Expected number");
        return Double.parseDouble(eStr.substring(start, ePos));
    }

    // ── Keyboard ───────────────────────────────────────────────────────
    private void handleKey(KeyEvent e) {
        char ch = e.getKeyChar();
        int code = e.getKeyCode();
        if (Character.isDigit(ch))                         { handleInput(String.valueOf(ch)); }
        else if (ch == '.')                                { handleInput("."); }
        else if (ch == '+')                                { handleInput("+"); }
        else if (ch == '-')                                { handleInput("−"); }
        else if (ch == '*')                                { handleInput("×"); }
        else if (ch == '/')                                { handleInput("÷"); }
        else if (code == KeyEvent.VK_ENTER)                { handleInput("="); }
        else if (code == KeyEvent.VK_BACK_SPACE
              || code == KeyEvent.VK_ESCAPE)               { handleInput("C"); }
    }

    // ── Format ─────────────────────────────────────────────────────────
    private String fmt(double v) {
        if (!Double.isInfinite(v) && !Double.isNaN(v) && v == Math.floor(v))
            return String.valueOf((long) v);
        return String.valueOf(v);
    }

    // ── Entry point ────────────────────────────────────────────────────
    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); }
        catch (Exception ignored) {}
        SwingUtilities.invokeLater(Calculator::new);
    }
}

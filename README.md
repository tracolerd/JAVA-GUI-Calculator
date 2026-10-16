<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:111827,50:7C3AED,100:0B1220&height=190&section=header&text=Java%20GUI%20Calculator&fontSize=42&fontColor=F1F5F9&fontAlignY=38&animation=fadeIn&desc=A%20dark-themed%20Swing%20calculator%20with%20expression%20parsing%20and%20keyboard%20input&descAlignY=61&descSize=15" alt="Java GUI Calculator animated project banner" width="100%" />
</p>
<h1 align="center">Java GUI Calculator</h1>


A sleek, fully-functional desktop calculator built with **Java Swing** — no external dependencies required, runs anywhere Java is installed.

![Java](https://img.shields.io/badge/Java-11%2B-orange?logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/GUI-Java%20Swing-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)
![Platform](https://img.shields.io/badge/Platform-Windows%20%7C%20macOS%20%7C%20Linux-lightgrey)

---

## ✨ Features

- **Basic Arithmetic** — Addition, Subtraction, Multiplication, Division
- **Utility Functions** — Toggle sign (±), Percentage (%), Clear (C)
- **Live Expression Preview** — Shows the full running expression above the main display
- **Custom Expression Evaluator** — Recursive-descent parser with correct operator precedence (no `eval()` hacks)
- **Keyboard Support** — Full number pad and keyboard input supported
- **Zero Division Handling** — Friendly error message, no crash
- **Dark UI** — Eye-friendly dark theme with colour-coded button groups
- **Zero Dependencies** — Only the Java Standard Library (JDK); nothing to `pip` or `npm` install

---

## 📸 Preview

```
┌──────────────────────────────────┐
│                    9 × 12 =      │
│                         108      │
├──────┬──────┬──────┬─────────────┤
│  C   │  ±   │  %   │      ÷      │
├──────┼──────┼──────┼─────────────┤
│  7   │  8   │  9   │      ×      │
├──────┼──────┼──────┼─────────────┤
│  4   │  5   │  6   │      −      │
├──────┼──────┼──────┼─────────────┤
│  1   │  2   │  3   │      +      │
├────────────┬──────┬──────────────┤
│     0      │  .   │      =       │
└────────────┴──────┴──────────────┘
```

---

## 🚀 Getting Started

### Prerequisites

| Tool | Version | Check command |
|------|---------|---------------|
| JDK  | 11 +    | `java -version` |
| `javac` | (bundled with JDK) | `javac -version` |

> ⚠️ Install the **JDK** (Java Development Kit), not just the JRE.
> The JDK includes `javac` which is needed to compile the source.

**Download JDK:**
- [Adoptium (free, open-source)](https://adoptium.net/)
- [Oracle JDK](https://www.oracle.com/java/technologies/downloads/)

---

### Installation

```bash
# Clone the repository
git clone https://github.com/tracolerd/JAVA-GUI-Calculator

# Navigate into the project folder
cd JAVA-GUI-Calculator
```

---

## ▶️ Running the Calculator

### Step 1 — Compile

```bash
javac Calculator.java
```

This produces a `Calculator.class` file in the same directory.

### Step 2 — Run

```bash
java Calculator
```

The calculator window opens immediately. ✅

---

### One-liner (compile + run)

```bash
javac Calculator.java && java Calculator
```

---

## ⌨️ Keyboard Shortcuts

| Key | Action |
|-----|--------|
| `0` – `9` | Input digits |
| `.` | Decimal point |
| `+` | Addition |
| `-` | Subtraction |
| `*` | Multiplication |
| `/` | Division |
| `Enter` | Evaluate (`=`) |
| `Backspace` / `Esc` | Clear |

---

## 📁 Project Structure

```
java-gui-calculator/
│
├── Calculator.java   # Full source — everything in one file
├── Calculator.class  # Generated after compilation (git-ignored)
└── README.md         # You are here
```

> **Tip:** Add `*.class` to your `.gitignore` so compiled bytecode is never committed.

---

## 🛠️ How It Works

| Layer | Detail |
|---|---|
| **GUI Framework** | Java Swing (`javax.swing`) |
| **Layout** | `BorderLayout` (overall) · `GridLayout` (button rows 0–3) · `GridBagLayout` (bottom row with double-wide zero) |
| **Expression Parsing** | Hand-written recursive-descent parser: `addSub → mulDiv → unary → number`. Handles operator precedence correctly without `eval()`. |
| **Keyboard Events** | `KeyAdapter.keyPressed()` bound to the frame; maps key chars to the same `handleInput()` method as mouse clicks |
| **Hover Effects** | `MouseAdapter.mouseEntered/Exited` darkens the button background on hover |

---

## 🤝 Contributing

Contributions and feature ideas are always welcome!

1. **Fork** the repository
2. Create your branch: `git checkout -b feature/my-feature`
3. Commit your changes: `git commit -m "Add my feature"`
4. Push: `git push origin feature/my-feature`
5. Open a **Pull Request**

---

## 📝 .gitignore suggestion

```gitignore
# Compiled Java bytecode
*.class
*.jar

# IDE files
.idea/
*.iml
.vscode/
```

---

## 📜 License

This project is licensed under the **MIT License** — free to use, modify, and distribute.

---

## 👤 Author

Made by Faiyaz using Java ☕

> *"Write once, run anywhere."* — Java motto

---

## Author & Development

**Project author and solo developer:** [Nurul Faiyaz](https://github.com/tracolerd).

This project is independently developed and maintained by Nurul Faiyaz. AI-assisted tools may be used as part of the development workflow; the project author remains responsible for technical decisions, code review, validation, and maintenance.


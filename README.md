<p align="center">
  <img src="assets/readme-hero.svg" alt="Java GUI Calculator — custom animated project banner" width="100%" />
</p>

<h1 align="center">Java GUI Calculator</h1>

<p align="center">
  <strong>A desktop calculator with an explicit expression parser.</strong><br/>
  A Java Swing interface with keyboard input, live expression preview and recursive-descent evaluation without eval-style shortcuts.
</p>

<p align="center">
  <a href="https://dev.java/"><img src="https://img.shields.io/badge/Java-Desktop_app-ED8B00?style=for-the-badge&amp;logo=openjdk&amp;logoColor=white" alt="Java — Desktop app" /></a>
  <a href="https://docs.oracle.com/javase/tutorial/uiswing/"><img src="https://img.shields.io/badge/Java_Swing-GUI-2563EB?style=for-the-badge&amp;logo=openjdk&amp;logoColor=white" alt="Java Swing — GUI" /></a>
  <a href="LICENSE"><img src="https://img.shields.io/badge/MIT-License-16A34A?style=for-the-badge&amp;logo=opensourceinitiative&amp;logoColor=white" alt="MIT — License" /></a>
</p>

<p align="center">
  <a href="#project-details">Project details</a> · <a href="#project-setup">Get started</a> · <a href="#project-architecture">How it works</a> · <a href="#creator-developer-maintainer">Creator</a>
</p>

---

<a id="project-details"></a>
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

<a id="project-setup"></a>
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

<a id="project-architecture"></a>
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
---

---

## Creator, Developer & Maintainer

**Created, designed, developed, documented, and maintained independently by [Nurul Faiyaz](https://github.com/tracolerd).**

<p align="center">
  <a href="https://www.facebook.com/faiyaz.888"><img src="https://img.shields.io/badge/Facebook-1877F2?style=for-the-badge&amp;logo=facebook&amp;logoColor=white" alt="Facebook" /></a>
  <a href="https://www.instagram.com/tracolerd"><img src="https://img.shields.io/badge/Instagram-E4405F?style=for-the-badge&amp;logo=instagram&amp;logoColor=white" alt="Instagram" /></a>
  <a href="https://www.linkedin.com/in/faiyaz-xyz"><img src="https://img.shields.io/badge/LinkedIn-0A66C2?style=for-the-badge&amp;logo=linkedin&amp;logoColor=white" alt="LinkedIn" /></a>
  <a href="https://x.com/faiyaz_explores"><img src="https://img.shields.io/badge/X-000000?style=for-the-badge&amp;logo=x&amp;logoColor=white" alt="X" /></a>
  <a href="https://github.com/tracolerd"><img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&amp;logo=github&amp;logoColor=white" alt="GitHub" /></a>
  <a href="mailto:scrollfaiyaz@gmail.com"><img src="https://img.shields.io/badge/Email-D14836?style=for-the-badge&amp;logo=gmail&amp;logoColor=white" alt="Email" /></a>
  <a href="https://nurul-faiyaz.netlify.app/"><img src="https://img.shields.io/badge/Portfolio-Visit%20Website-0F766E?style=for-the-badge&amp;logo=googlechrome&amp;logoColor=white" alt="Website" /></a>
</p>

<p align="center">
  <a href="https://www.facebook.com/faiyaz.888">Facebook</a> ·
  <a href="https://www.instagram.com/tracolerd">Instagram</a> ·
  <a href="https://www.linkedin.com/in/faiyaz-xyz">LinkedIn</a> ·
  <a href="https://x.com/faiyaz_explores">X / Twitter</a> ·
  <a href="https://github.com/tracolerd">GitHub</a> ·
  <a href="mailto:scrollfaiyaz@gmail.com">Email</a> ·
  <a href="https://nurul-faiyaz.netlify.app/">Website</a>
</p>

## License

See [LICENSE](LICENSE) for the license terms.

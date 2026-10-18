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
---

## Creator, Developer & Maintainer

**Created, designed, developed, and maintained by [Nurul Faiyaz](https://github.com/tracolerd).**

This project is independently built and maintained by Nurul Faiyaz. The project's design, implementation, and documentation are his work.

<p align="center">
  <a href="https://www.facebook.com/faiyaz.888"><img src="https://img.shields.io/badge/Facebook-1877F2?style=for-the-badge&logo=facebook&logoColor=white" alt="Facebook" /></a>
  <a href="https://www.instagram.com/tracolerd"><img src="https://img.shields.io/badge/Instagram-E4405F?style=for-the-badge&logo=instagram&logoColor=white" alt="Instagram" /></a>
  <a href="https://www.linkedin.com/in/faiyaz-xyz"><img src="https://img.shields.io/badge/LinkedIn-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn" /></a>
  <a href="https://x.com/faiyaz_explores"><img src="https://img.shields.io/badge/X-000000?style=for-the-badge&logo=x&logoColor=white" alt="X" /></a>
  <a href="https://github.com/tracolerd"><img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white" alt="GitHub" /></a>
  <a href="mailto:scrollfaiyaz@gmail.com"><img src="https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white" alt="Email" /></a>
  <a href="https://nurul-faiyaz.netlify.app/"><img src="https://img.shields.io/badge/Portfolio-Visit%20Website-0F766E?style=for-the-badge&logo=googlechrome&logoColor=white" alt="Personal website" /></a>
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

## 📜 License

This project is licensed under the **MIT License** — free to use, modify, and distribute.

---
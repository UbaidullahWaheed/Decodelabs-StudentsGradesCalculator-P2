# 📊 Student Grade Calculator

<div align="center">

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=java)
![CLI](https://img.shields.io/badge/Interface-CLI-blue?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)
![DecodeLabs](https://img.shields.io/badge/DecodeLabs-Batch%202026-purple?style=for-the-badge)

**A feature-rich, colorful command-line Student Grade Calculator with analytics, GPA, progress bars, and a professional report card — built in Java.**

*DecodeLabs — Batch 2026 · Project 2 · v3.0*

</div>

---

## 📌 About The Project

The **Student Grade Calculator** is a fully-featured terminal application built in Java that takes student and subject data as input and generates a **complete official report card** with color-coded output, visual progress bars, detailed analytics, GPA calculation, merit ranking, and motivational feedback — all beautifully styled with ANSI colors directly in the terminal.

No external libraries. No GUI frameworks. Just pure Java — and it looks stunning.

---

## ✨ Features

### 🎓 Student Profile
- Enter student **name**, **roll number**, and **class/section**
- Supports any number of subjects
- Custom **subject names** and **maximum marks** per subject

### 📋 Report Card
- Per-subject table showing marks obtained, max marks, percentage, and grade
- Color-coded grades — green for A+, cyan for B, yellow for C, red for F
- **Overall total** row with cumulative percentage and final grade
- Visual **progress bars** (█░░░) for overall and per-subject performance

### 📊 Analytics Panel
- 🏆 Highest scoring subject
- 📉 Lowest scoring subject
- 📐 Standard deviation across subjects
- 🎯 GPA on a 4.0 scale
- 🥇 Merit rank (Gold Merit / Silver Merit / Distinction / First Division)
- ✅ Subjects cleared vs total
- ❌ Failed subjects listed individually
- ⚠️ Marks needed to pass (if the student failed)

### 🎨 UI & Experience
- Full **ANSI color** terminal output (text colors, bright colors, backgrounds)
- **Loading animation** with spinner while processing
- **Animated character-by-character** text printing
- Centered text formatting with dynamic padding
- **Motivational message** based on performance
- Re-run for another student without restarting
- Clean **banner** and **report card** borders using box-drawing characters

---

## 🗂️ Grade Scale

| Percentage | Grade | Label |
|---|---|---|
| ≥ 95% | A+ | Outstanding |
| ≥ 85% | A | Excellent |
| ≥ 70% | B | Good |
| ≥ 55% | C | Average |
| ≥ 40% | D | Below Average |
| < 40% | F | Fail |

---

## 🏅 Merit Rank Scale

| Percentage | Rank |
|---|---|
| ≥ 95% | 🥇 Gold Merit |
| ≥ 85% | 🥈 Silver Merit |
| ≥ 70% | 🏅 Distinction |
| ≥ 55% | First Division |
| ≥ 40% | Second Division |
| < 40% | Failed |

---

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Any terminal that supports ANSI colors (Windows Terminal, VS Code Terminal, macOS Terminal, Linux)

### Compile & Run

```bash
# Clone the repository
git clone https://github.com/YOUR_USERNAME/DecodeLabs_GradeCalculator.git
cd DecodeLabs_GradeCalculator

# Compile
javac GradeCalculator.java

# Run
java GradeCalculator
```

---

## 🎮 How To Use

```
1. Enter student name, roll number, and class/section
2. Enter the number of subjects
3. For each subject:
   - Enter subject name
   - Enter maximum marks
   - Enter marks obtained
4. View the full color-coded report card instantly!
5. Choose to run again for another student or exit
```

---

## 📸 Sample Output

```
════════════════════════════════════════════════════════════
        ★  DECODELABS  STUDENT  GRADE  CALCULATOR  ★
              Batch 2026  |  Project 2  |  v3.0
════════════════════════════════════════════════════════════

  ╔══ STUDENT PROFILE ══╗
  Enter student name   : Ali Hassan
  Enter roll number    : 2026-CS-045
  Enter class/section  : CS-A

  Enter number of subjects  : 3

  [Subject 1]
  Subject name     : Mathematics
  Maximum marks    : 100
  Marks obtained   : 92

  ...

════════════════════════════════════════════════════════════
                   ★  OFFICIAL REPORT CARD  ★
════════════════════════════════════════════════════════════
  Name        : Ali Hassan
  Roll No.    : 2026-CS-045
  Class       : CS-A
  ────────────────────────────────────────────────────────
  Subject            Marks    Max      Pct   Grade
  ────────────────────────────────────────────────────────
  Mathematics           92    100    92.0%   A+
  Physics               78    100    78.0%   B
  Chemistry             65    100    65.0%   C
  ────────────────────────────────────────────────────────
  TOTAL / OVERALL      235    300    78.33%  B
════════════════════════════════════════════════════════════

  Overall    ████████████████████████████░░░░░░░░  78.3%
  Mathemati  █████████████████████████████████░░░  92.0%
  Physics    ████████████████████████████░░░░░░░░  78.0%
  Chemistry  ███████████████████████░░░░░░░░░░░░░  65.0%

  ANALYTICS
  Highest scoring subject      : Mathematics (92.0%)
  Lowest scoring subject       : Chemistry (65.0%)
  Standard deviation           : 11.14
  GPA (4.0 scale)              : 3.13 / 4.00
  Merit rank                   : Distinction
  Subjects cleared (>=40%)     : 3 / 3

  GRADE  : B  [GOOD]
  RESULT : PASS

  Good performance. A little more effort = A grade.
════════════════════════════════════════════════════════════
```

---

## 📁 Project Structure

```
DecodeLabs_GradeCalculator/
│
├── GradeCalculator.java    # Main application (single file)
└── README.md               # Project documentation
```

---

## 🛠️ Built With

- **Java** — Core programming language
- **java.util.Scanner** — User input
- **java.util.ArrayList & Collections** — Data handling
- **ANSI Escape Codes** — Terminal colors and styling
- **Math** — Standard deviation, GPA, pass mark calculation

> ✅ Zero external dependencies — compile and run instantly!

---

## 👨‍💻 Developer

**Ubaidullah Waheed**
- 🎓 DecodeLabs — Batch 2026
- 💼 LinkedIn: [linkedin.com/in/ubaidullah-waheed-a119ba383](https://www.linkedin.com/in/ubaidullah-waheed-a119ba383/)
- 🐙 GitHub: [github.com/UbaidullahWaheed](https://github.com/UbaidullahWaheed)

---

## 📄 License

This project is licensed under the **MIT License** — feel free to use and modify it!

---

<div align="center">

⭐ **If you found this project helpful, please give it a star!** ⭐

*Built with ❤️ by Ubaidullah Waheed — DecodeLabs Batch 2026*

</div>

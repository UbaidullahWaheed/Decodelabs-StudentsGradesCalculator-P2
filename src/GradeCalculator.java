import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class GradeCalculator {

    // ══════════════════════════════════════════════════════
    //   ANSI COLOR & STYLE CODES
    // ══════════════════════════════════════════════════════
    static final String RESET   = "\u001B[0m";
    static final String BOLD    = "\u001B[1m";
    static final String DIM     = "\u001B[2m";

    // Text Colors
    static final String BLACK   = "\u001B[30m";
    static final String RED     = "\u001B[31m";
    static final String GREEN   = "\u001B[32m";
    static final String YELLOW  = "\u001B[33m";
    static final String BLUE    = "\u001B[34m";
    static final String MAGENTA = "\u001B[35m";
    static final String CYAN    = "\u001B[36m";
    static final String WHITE   = "\u001B[37m";

    // Bright Text Colors
    static final String BRIGHT_RED     = "\u001B[91m";
    static final String BRIGHT_GREEN   = "\u001B[92m";
    static final String BRIGHT_YELLOW  = "\u001B[93m";
    static final String BRIGHT_BLUE    = "\u001B[94m";
    static final String BRIGHT_MAGENTA = "\u001B[95m";
    static final String BRIGHT_CYAN    = "\u001B[96m";
    static final String BRIGHT_WHITE   = "\u001B[97m";

    // Background Colors
    static final String BG_BLACK   = "\u001B[40m";
    static final String BG_RED     = "\u001B[41m";
    static final String BG_GREEN   = "\u001B[42m";
    static final String BG_YELLOW  = "\u001B[43m";
    static final String BG_BLUE    = "\u001B[44m";
    static final String BG_MAGENTA = "\u001B[45m";
    static final String BG_CYAN    = "\u001B[46m";
    static final String BG_WHITE   = "\u001B[47m";

    // ══════════════════════════════════════════════════════
    //   HELPER METHODS
    // ══════════════════════════════════════════════════════

    static void printLine(String color, int length) {
        System.out.println(color + "═".repeat(length) + RESET);
    }

    static void printThinLine(String color, int length) {
        System.out.println(color + "─".repeat(length) + RESET);
    }

    static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {}
    }

    static void animatePrint(String text, int delay) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            sleep(delay);
        }
        System.out.println();
    }

    static void printCentered(String text, int width, String color) {
        int padding = (width - text.replaceAll("\u001B\\[[;\\d]*m", "").length()) / 2;
        if (padding < 0) padding = 0;
        System.out.println(color + " ".repeat(padding) + text + RESET);
    }

    static String getGradeColor(String grade) {
        switch (grade) {
            case "A+": return BRIGHT_GREEN;
            case "A":  return GREEN;
            case "B":  return BRIGHT_CYAN;
            case "C":  return BRIGHT_YELLOW;
            case "D":  return YELLOW;
            case "F":  return BRIGHT_RED;
            default:   return WHITE;
        }
    }

    static String getPercentageBar(double pct, int maxWidth) {
        int filled = (int) (pct / 100.0 * maxWidth);
        String barColor = pct >= 80 ? BRIGHT_GREEN : pct >= 60 ? BRIGHT_YELLOW : BRIGHT_RED;
        String bar = barColor + "█".repeat(filled) + DIM + "░".repeat(maxWidth - filled) + RESET;
        return bar;
    }

    static String getGradeEmoji(String grade) {
        switch (grade) {
            case "A+": return " [OUTSTANDING]";
            case "A":  return " [EXCELLENT]";
            case "B":  return " [GOOD]";
            case "C":  return " [AVERAGE]";
            case "D":  return " [BELOW AVERAGE]";
            case "F":  return " [FAIL]";
            default:   return "";
        }
    }

    // ══════════════════════════════════════════════════════
    //   BANNER
    // ══════════════════════════════════════════════════════
    static void printBanner() {
        System.out.println();
        printLine(BRIGHT_CYAN, 60);
        System.out.println(BRIGHT_CYAN + "║" + RESET
            + BOLD + BRIGHT_YELLOW
            + "        ★  DECODELABS  STUDENT  GRADE  CALCULATOR  ★       "
            + RESET + BRIGHT_CYAN + "║" + RESET);
        System.out.println(BRIGHT_CYAN + "║" + RESET
            + DIM + BRIGHT_WHITE
            + "              Batch 2026  |  Project 2  |  v3.0              "
            + RESET + BRIGHT_CYAN + "║" + RESET);
        printLine(BRIGHT_CYAN, 60);
        System.out.println();
        sleep(300);
    }

    // ══════════════════════════════════════════════════════
    //   LOADING ANIMATION
    // ══════════════════════════════════════════════════════
    static void loadingAnimation(String msg) {
        String[] frames = {"|", "/", "-", "\\"};
        System.out.print(BRIGHT_CYAN + msg + "  " + RESET);
        for (int i = 0; i < 12; i++) {
            System.out.print("\b\b" + BRIGHT_YELLOW + frames[i % 4] + " " + RESET);
            sleep(80);
        }
        System.out.println("\b\b" + BRIGHT_GREEN + "✔ Done" + RESET);
    }

    // ══════════════════════════════════════════════════════
    //   GRADE LOGIC  (supports custom max marks)
    // ══════════════════════════════════════════════════════
    static String assignGrade(double percentage) {
        if (percentage >= 95) return "A+";
        if (percentage >= 85) return "A";
        if (percentage >= 70) return "B";
        if (percentage >= 55) return "C";
        if (percentage >= 40) return "D";
        return "F";
    }

    // ══════════════════════════════════════════════════════
    //   MAIN
    // ══════════════════════════════════════════════════════
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        printBanner();

        // ── [UPGRADE 1] Student profile input ─────────────
        System.out.println(BOLD + BRIGHT_MAGENTA + "  ╔══ STUDENT PROFILE ══╗" + RESET);
        System.out.print(BRIGHT_WHITE + "  Enter student name   : " + RESET + BRIGHT_YELLOW);
        String name = sc.nextLine().trim();
        System.out.print(RESET + BRIGHT_WHITE + "  Enter roll number    : " + RESET + BRIGHT_YELLOW);
        String roll = sc.nextLine().trim();

        // ── [UPGRADE 2] Class / Section input ─────────────
        System.out.print(RESET + BRIGHT_WHITE + "  Enter class/section  : " + RESET + BRIGHT_YELLOW);
        String section = sc.nextLine().trim();
        System.out.println(RESET);

        // ── Number of subjects ─────────────────────────────
        int numSubjects = 0;
        while (numSubjects <= 0) {
            System.out.print(BRIGHT_CYAN + "  Enter number of subjects  : " + RESET + BRIGHT_YELLOW);
            try {
                numSubjects = Integer.parseInt(sc.nextLine().trim());
                if (numSubjects <= 0)
                    System.out.println(BRIGHT_RED + "  [!] Must be at least 1." + RESET);
            } catch (NumberFormatException e) {
                System.out.println(BRIGHT_RED + "  [!] Please enter a valid number." + RESET);
                numSubjects = 0;
            }
        }
        System.out.println();

        // ══════════════════════════════════════════════════
        //   PER-SUBJECT INPUT
        // ══════════════════════════════════════════════════
        String[]  subjectNames   = new String[numSubjects];
        int[]     marksObtained  = new int[numSubjects];
        int[]     maxMarks       = new int[numSubjects];     // [UPGRADE 3] custom max marks
        double[]  subjectPct     = new double[numSubjects];
        String[]  subjectGrades  = new String[numSubjects];
        int       totalObtained  = 0;
        int       totalMax       = 0;

        printLine(BRIGHT_BLUE, 60);
        System.out.println(BOLD + BRIGHT_BLUE + "  SUBJECT MARKS ENTRY" + RESET);
        printLine(BRIGHT_BLUE, 60);

        for (int i = 0; i < numSubjects; i++) {
            System.out.println();
            System.out.println(BRIGHT_MAGENTA + "  ┌─ Subject " + (i + 1) + " ─────────────────────────────┐" + RESET);

            // Subject name [UPGRADE 4]
            System.out.print(BRIGHT_WHITE + "  │  Name             : " + RESET + BRIGHT_YELLOW);
            subjectNames[i] = sc.nextLine().trim();
            if (subjectNames[i].isEmpty()) subjectNames[i] = "Subject " + (i + 1);

            // Max marks [UPGRADE 3] — user defined
            maxMarks[i] = 0;
            while (maxMarks[i] <= 0) {
                System.out.print(RESET + BRIGHT_WHITE + "  │  Max marks         : " + RESET + BRIGHT_YELLOW);
                try {
                    maxMarks[i] = Integer.parseInt(sc.nextLine().trim());
                    if (maxMarks[i] <= 0)
                        System.out.println(RESET + BRIGHT_RED + "  │  [!] Max marks must be > 0." + RESET);
                } catch (NumberFormatException e) {
                    System.out.println(RESET + BRIGHT_RED + "  │  [!] Invalid number." + RESET);
                    maxMarks[i] = 0;
                }
            }

            // Marks obtained with validation
            marksObtained[i] = -1;
            while (marksObtained[i] < 0 || marksObtained[i] > maxMarks[i]) {
                System.out.print(RESET + BRIGHT_WHITE + "  │  Marks obtained    : " + RESET + BRIGHT_YELLOW);
                try {
                    marksObtained[i] = Integer.parseInt(sc.nextLine().trim());
                    if (marksObtained[i] < 0 || marksObtained[i] > maxMarks[i])
                        System.out.println(RESET + BRIGHT_RED + "  │  [!] Enter between 0 and " + maxMarks[i] + "." + RESET);
                } catch (NumberFormatException e) {
                    System.out.println(RESET + BRIGHT_RED + "  │  [!] Invalid number." + RESET);
                    marksObtained[i] = -1;
                }
            }

            // Per-subject calculation
            subjectPct[i]    = (double) marksObtained[i] / maxMarks[i] * 100.0;
            subjectGrades[i] = assignGrade(subjectPct[i]);
            totalObtained   += marksObtained[i];
            totalMax        += maxMarks[i];

            String gColor = getGradeColor(subjectGrades[i]);
            System.out.println(RESET + BRIGHT_WHITE + "  │  Percentage        : "
                + gColor + BOLD + String.format("%.2f%%", subjectPct[i]) + RESET
                + "  Grade: " + gColor + BOLD + subjectGrades[i] + RESET);
            System.out.println(BRIGHT_MAGENTA + "  └───────────────────────────────────────────┘" + RESET);
        }

        // ══════════════════════════════════════════════════
        //   CALCULATIONS
        // ══════════════════════════════════════════════════
        sleep(300);
        System.out.println();
        loadingAnimation("  Processing results");
        sleep(200);

        double overallPct   = (double) totalObtained / totalMax * 100.0;
        String overallGrade = assignGrade(overallPct);
        String result       = (overallPct >= 40) ? "PASS" : "FAIL";

        // [UPGRADE 5] Highest & lowest subject
        double highest = subjectPct[0], lowest = subjectPct[0];
        int    hiIdx   = 0,             loIdx  = 0;
        for (int i = 1; i < numSubjects; i++) {
            if (subjectPct[i] > highest) { highest = subjectPct[i]; hiIdx = i; }
            if (subjectPct[i] < lowest)  { lowest  = subjectPct[i]; loIdx = i; }
        }

        // [UPGRADE 6] GPA on 4.0 scale
        double gpa = overallPct / 100.0 * 4.0;

        // [UPGRADE 7] Rank / Percentile label
        String rank;
        if      (overallPct >= 95) rank = "Gold Merit";
        else if (overallPct >= 85) rank = "Silver Merit";
        else if (overallPct >= 70) rank = "Distinction";
        else if (overallPct >= 55) rank = "First Division";
        else if (overallPct >= 40) rank = "Second Division";
        else                       rank = "Failed";

        // [UPGRADE 8] Marks needed to pass (if failed)
        int marksNeeded = 0;
        if (overallPct < 40) {
            int passMark = (int) Math.ceil(totalMax * 0.40);
            marksNeeded = passMark - totalObtained;
        }

        // [UPGRADE 9] Standard deviation
        double mean = 0;
        for (double p : subjectPct) mean += p;
        mean /= numSubjects;
        double variance = 0;
        for (double p : subjectPct) variance += (p - mean) * (p - mean);
        double stdDev = Math.sqrt(variance / numSubjects);

        // [UPGRADE 10] Count subjects failed
        int subjectsFailed = 0;
        for (double p : subjectPct) if (p < 40) subjectsFailed++;

        // ══════════════════════════════════════════════════
        //   FINAL REPORT CARD
        // ══════════════════════════════════════════════════
        System.out.println();
        printLine(BRIGHT_CYAN, 60);
        printCentered(BOLD + BRIGHT_YELLOW + "★  OFFICIAL REPORT CARD  ★" + RESET, 60, "");
        printLine(BRIGHT_CYAN, 60);

        // Student info block
        System.out.println(BRIGHT_WHITE + "  Name        : " + BOLD + BRIGHT_YELLOW + name + RESET);
        System.out.println(BRIGHT_WHITE + "  Roll No.    : " + BRIGHT_CYAN   + roll    + RESET);
        System.out.println(BRIGHT_WHITE + "  Class       : " + BRIGHT_CYAN   + section + RESET);
        printThinLine(BRIGHT_BLUE, 60);

        // Per-subject table header
        System.out.printf(BOLD + BRIGHT_WHITE + "  %-18s %6s %6s %7s  %s%n" + RESET,
            "Subject", "Marks", "Max", "  Pct", "Grade");
        printThinLine(DIM + WHITE, 60);

        for (int i = 0; i < numSubjects; i++) {
            String gc = getGradeColor(subjectGrades[i]);
            System.out.printf("  " + BRIGHT_WHITE + "%-18s" + RESET
                + " %s%6d" + RESET + " %s%6d" + RESET
                + " %s%6.1f%%" + RESET + "  " + gc + BOLD + "%s" + RESET + "%n",
                subjectNames[i],
                BRIGHT_CYAN,    marksObtained[i],
                DIM + WHITE,    maxMarks[i],
                gc,             subjectPct[i],
                subjectGrades[i]);
        }

        printThinLine(BRIGHT_BLUE, 60);

        // Totals row
        System.out.printf("  " + BOLD + BRIGHT_WHITE + "%-18s" + RESET
            + " " + BOLD + BRIGHT_GREEN + "%6d" + RESET
            + " " + DIM  + WHITE        + "%6d" + RESET
            + " " + BOLD + BRIGHT_GREEN + "%6.2f%%" + RESET + "  "
            + BOLD + getGradeColor(overallGrade) + "%-3s" + RESET + "%n",
            "TOTAL / OVERALL",
            totalObtained, totalMax, overallPct, overallGrade);

        printLine(BRIGHT_CYAN, 60);

        // [UPGRADE 11] Visual percentage bar
        System.out.println();
        System.out.print("  Overall  " + BRIGHT_WHITE);
        System.out.print(getPercentageBar(overallPct, 36));
        System.out.printf(BRIGHT_WHITE + " %.1f%%" + RESET + "%n", overallPct);

        // Per-subject bars
        for (int i = 0; i < numSubjects; i++) {
            String label = subjectNames[i].length() > 9
                ? subjectNames[i].substring(0, 9) : subjectNames[i];
            System.out.printf("  %-9s  ", label);
            System.out.print(getPercentageBar(subjectPct[i], 36));
            System.out.printf(BRIGHT_WHITE + " %.1f%%" + RESET + "%n", subjectPct[i]);
        }

        printThinLine(BRIGHT_BLUE, 60);

        // [UPGRADE 12] Analytics panel
        System.out.println(BOLD + BRIGHT_MAGENTA + "  ANALYTICS" + RESET);
        System.out.printf("  %-28s : " + BRIGHT_GREEN  + "%-15s%n" + RESET,
            "Highest scoring subject", subjectNames[hiIdx] + String.format(" (%.1f%%)", highest));
        System.out.printf("  %-28s : " + BRIGHT_RED    + "%-15s%n" + RESET,
            "Lowest scoring subject",  subjectNames[loIdx] + String.format(" (%.1f%%)", lowest));
        System.out.printf("  %-28s : " + BRIGHT_CYAN   + "%.2f%n"  + RESET, "Standard deviation", stdDev);
        System.out.printf("  %-28s : " + BRIGHT_YELLOW + "%.2f / 4.00%n" + RESET, "GPA (4.0 scale)", gpa);
        System.out.printf("  %-28s : " + BRIGHT_CYAN   + "%s%n"   + RESET, "Merit rank", rank);
        System.out.printf("  %-28s : " + BRIGHT_YELLOW + "%d / %d%n" + RESET,
            "Subjects cleared (>=40%%)", numSubjects - subjectsFailed, numSubjects);

        if (subjectsFailed > 0) {
            // [UPGRADE 8] Show which subjects failed
            System.out.printf("  %-28s : " + BRIGHT_RED + "%d%n" + RESET,
                "Subjects failed", subjectsFailed);
            System.out.print(BRIGHT_RED + "  Failed in: ");
            for (int i = 0; i < numSubjects; i++)
                if (subjectPct[i] < 40) System.out.print(subjectNames[i] + "  ");
            System.out.println(RESET);
        }

        if (marksNeeded > 0) {
            System.out.printf("  %-28s : " + BRIGHT_RED + "%d marks%n" + RESET,
                "Additional marks needed to pass", marksNeeded);
        }

        printThinLine(BRIGHT_BLUE, 60);

        // [UPGRADE 13] RESULT banner
        String resultColor = result.equals("PASS") ? BG_GREEN + BLACK : BG_RED + BRIGHT_WHITE;
        String gradeColor  = getGradeColor(overallGrade);

        System.out.println();
        System.out.println("  " + BOLD + gradeColor  + "  GRADE  : " + overallGrade
            + getGradeEmoji(overallGrade) + RESET);
        System.out.println("  " + BOLD + resultColor + "  RESULT : " + result + "  " + RESET);
        System.out.println();

        // [UPGRADE 14] Motivational message
        System.out.print("  " + DIM + BRIGHT_WHITE);
        if      (overallPct >= 95) System.out.println("Absolutely outstanding! You are at the top!");
        else if (overallPct >= 85) System.out.println("Excellent work! Keep pushing for that A+.");
        else if (overallPct >= 70) System.out.println("Good performance. A little more effort = A grade.");
        else if (overallPct >= 55) System.out.println("Decent effort. Focus on weak subjects to level up.");
        else if (overallPct >= 40) System.out.println("You passed, but there's a lot of room to improve.");
        else                       System.out.println("Don't give up. Analyze mistakes and bounce back!");
        System.out.print(RESET);

        printLine(BRIGHT_CYAN, 60);

        // [UPGRADE 15] Re-run or exit prompt
        System.out.println();
        System.out.print(BRIGHT_CYAN + "  Run again for another student? (y/n): " + RESET + BRIGHT_YELLOW);
        String again = sc.nextLine().trim().toLowerCase();
        System.out.print(RESET);

        if (again.equals("y") || again.equals("yes")) {
            System.out.println(BRIGHT_GREEN + "\n  Restarting...\n" + RESET);
            sleep(500);
            main(args);
        } else {
            System.out.println();
            printLine(BRIGHT_CYAN, 60);
            System.out.println(BOLD + BRIGHT_YELLOW
                + "        Thank you for using DecodeLabs Grade Calc!       " + RESET);
            printLine(BRIGHT_CYAN, 60);
            System.out.println();
        }

        sc.close();
    }
}
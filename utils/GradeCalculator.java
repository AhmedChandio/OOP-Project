package utils;

public class GradeCalculator {

    public static String calculateGrade(int marks) {

        if (marks >= 90) {
            return "A";
        } else if (marks >= 80) {
            return "B";
        } else if (marks >= 70) {
            return "C";
        } else if (marks >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static String getStatus(int marks) {

        if (marks >= 50) {
            return "PASS";
        }

        return "FAIL";
    }
}
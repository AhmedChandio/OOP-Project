package model;

public class Result {

    private int rollNo;
    private int marks;
    private String grade;
    private String status;

    public Result() {
    }

    public Result(int rollNo, int marks, String grade, String status) {
        this.rollNo = rollNo;
        this.marks = marks;
        this.grade = grade;
        this.status = status;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
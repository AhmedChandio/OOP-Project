package model;

public class Student extends Person {

    private int rollNo;
    private String className;

    public Student() {
    }

    public Student(String name, int rollNo, String className) {
        super(name);
        this.rollNo = rollNo;
        this.className = className;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return rollNo + " - " + name + " - " + className;
    }
}
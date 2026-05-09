package utils;

import model.Result;
import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public static void saveStudents(List<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
            for (Student student : students) {
                writer.write(student.getRollNo() + "," + student.getName() + "," + student.getClassName());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        File file = new File("students.txt");
        if (!file.exists()) return students;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    students.add(new Student(parts[1], Integer.parseInt(parts[0]), parts[2]));
                } else {
                    String[] oldParts = line.split(" - ");
                    if (oldParts.length == 3) {
                        students.add(new Student(oldParts[1], Integer.parseInt(oldParts[0].trim()), oldParts[2]));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void saveResults(List<Result> results) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"))) {
            for (Result result : results) {
                writer.write(result.getRollNo() + "," + result.getMarks() + "," + result.getGrade() + "," + result.getStatus());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Result> loadResults() {
        List<Result> results = new ArrayList<>();
        File file = new File("results.txt");
        if (!file.exists()) return results;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    results.add(new Result(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), parts[2], parts[3]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
}
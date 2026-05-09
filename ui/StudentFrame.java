package ui;

import model.Student;
import utils.FileHandler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentFrame extends JFrame {

    private JTextField nameField;
    private JTextField rollField;
    private JTextField classField;

    private JTextArea displayArea;

    private ArrayList<Student> students;

    public StudentFrame() {

        students = (ArrayList<Student>) FileHandler.loadStudents();

        setTitle("Student Management");
        setSize(500, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Name"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Roll No"));
        rollField = new JTextField();
        panel.add(rollField);

        panel.add(new JLabel("Class"));
        classField = new JTextField();
        panel.add(classField);

        JButton addButton = new JButton("Add Student");
        JButton viewButton = new JButton("View Students");

        panel.add(addButton);
        panel.add(viewButton);

        displayArea = new JTextArea();

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        addButton.addActionListener(e -> addStudent());
        viewButton.addActionListener(e -> viewStudents());

        setVisible(true);
    }

    private void addStudent() {

        String name = nameField.getText().trim();
        String rollText = rollField.getText().trim();
        String className = classField.getText().trim();

        if (name.isEmpty() || rollText.isEmpty() || className.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
            return;
        }

        int roll;
        try {
            roll = Integer.parseInt(rollText);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid roll number");
            return;
        }

        Student student = new Student(name, roll, className);
        students.add(student);
        FileHandler.saveStudents(students);

        JOptionPane.showMessageDialog(this, "Student added");

        nameField.setText("");
        rollField.setText("");
        classField.setText("");
    }

    private void viewStudents() {
        StringBuilder sb = new StringBuilder();
        for (Student s : students) {
            sb.append(s.toString()).append("\n");
        }
        displayArea.setText(sb.toString());
    }
}
package ui;

import model.Result;
import utils.GradeCalculator;

import javax.swing.*;
import java.awt.*;


public class ResultFrame extends JFrame {

    private JTextField rollField;
    private JTextField marksField;

    private JTextArea resultArea;

    private java.util.ArrayList<Result> results;

    public ResultFrame() {

        results = (java.util.ArrayList<Result>) utils.FileHandler.loadResults();

        setTitle("Result Management");
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        panel.add(new JLabel("Roll No"));
        rollField = new JTextField();
        panel.add(rollField);

        panel.add(new JLabel("Marks"));
        marksField = new JTextField();
        panel.add(marksField);

        JButton calculateButton = new JButton("Generate Result");
        JButton viewButton = new JButton("View Results");
        panel.add(calculateButton);
        panel.add(viewButton);

        resultArea = new JTextArea();

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        calculateButton.addActionListener(e -> {

            String rollText = rollField.getText().trim();
            String marksText = marksField.getText().trim();

            if (rollText.isEmpty() || marksText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter roll number and marks");
                return;
            }

            int roll;
            int marks;
            try {
                roll = Integer.parseInt(rollText);
                marks = Integer.parseInt(marksText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Roll and marks must be numbers");
                return;
            }

            Result result = new Result();
            result.setRollNo(roll);
            result.setMarks(marks);
            result.setGrade(GradeCalculator.calculateGrade(marks));
            result.setStatus(GradeCalculator.getStatus(marks));

            results.add(result);
            utils.FileHandler.saveResults(results);

            StringBuilder sb = new StringBuilder();
            sb.append("Roll No: ").append(result.getRollNo()).append("\n");
            sb.append("Marks: ").append(result.getMarks()).append("\n");
            sb.append("Grade: ").append(result.getGrade()).append("\n");
            sb.append("Status: ").append(result.getStatus()).append("\n");

            resultArea.setText(sb.toString());
            JOptionPane.showMessageDialog(this, "Result generated and saved.");
        });

        viewButton.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (Result r : results) {
                sb.append("Roll No: ").append(r.getRollNo())
                  .append(" - Marks: ").append(r.getMarks())
                  .append(" - Grade: ").append(r.getGrade())
                  .append(" - Status: ").append(r.getStatus()).append("\n");
            }
            resultArea.setText(sb.toString());
        });

        setVisible(true);
    }
}

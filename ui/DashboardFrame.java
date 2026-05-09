package ui;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {

        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 1, 20, 20));

        JButton studentButton = new JButton("Student Management");
        JButton resultButton = new JButton("Result Management");

        panel.add(studentButton);
        panel.add(resultButton);

        add(panel);

        studentButton.addActionListener(e -> new StudentFrame());
        resultButton.addActionListener(e -> new ResultFrame());

        setVisible(true);
    }
}
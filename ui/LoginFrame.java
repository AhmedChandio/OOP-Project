package ui;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginFrame() {

        setTitle("Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginButton = new JButton("Login");
        panel.add(new JLabel());
        panel.add(loginButton);

        add(panel);

        loginButton.addActionListener(e -> login());

        setVisible(true);
    }

    private void login() {

        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());

        if (username.equals("admin") && password.equals("1234")) {

            JOptionPane.showMessageDialog(this,
                    "Login Successful");

            new DashboardFrame();
            dispose();

        } else {

            JOptionPane.showMessageDialog(this,
                    "Invalid Login");
        }
    }
}
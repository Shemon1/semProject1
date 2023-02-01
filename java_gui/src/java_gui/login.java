package java_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
	static JTextField usernameField = new JTextField(15);
    static JPasswordField passwordField = new JPasswordField(15);
    public static void main(String[] args) {
        // JFrame for login
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(500, 250);

        // JPanel for layout
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginFrame.add(loginPanel);
        GridBagConstraints gbc = new GridBagConstraints();

        // "Welcome!" label
        JLabel welcomeLabel = new JLabel("Welcome!");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        loginPanel.add(welcomeLabel, gbc);

        // "Bruger ID" label
        JLabel usernameLabel = new JLabel("Bruger ID:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 0, 10);
        loginPanel.add(usernameLabel, gbc);

        // Username field next to label
        gbc.gridx = 1;
        loginPanel.add(usernameField, gbc);

        // "Kodeord" label
        JLabel passwordLabel = new JLabel("Kodeord:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(passwordLabel, gbc);

        // Password field next to label
        gbc.gridx = 1;
        loginPanel.add(passwordField, gbc);

        // "Login" button
        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 3;
        loginPanel.add(loginButton, gbc);

        // Show the login frame
        loginFrame.setVisible(true);

        // ActionListener for the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                if(e.getSource()==loginButton) {
                    if(username.equals("Anders") && password.equals("123")) {
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        Menu menuPage = new Menu();
                        
                        // Hide the login frame after login
                        loginFrame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Username or Password did not match");
                    }
                }
                
            }
        });

    }
}

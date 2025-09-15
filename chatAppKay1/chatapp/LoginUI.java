package com.chatapp.ui;

import com.chatapp.service.UserService;

import javax.swing.JOptionPane;

/**
 * This class manages the user interface for login.
 */
public class LoginUI {

    /**
     * Displays the login dialog.
     *
     * @param userService The user service for validation
     * @return The logged-in username or null if failed
     */
    public static String showLoginDialog(UserService userService) {
        String username = JOptionPane.showInputDialog(null,
                "Enter your username:",
                "Login",
                JOptionPane.QUESTION_MESSAGE);

        // Check if the user canceled
        if (username == null) {
            return null;
        }

        String password = JOptionPane.showInputDialog(null,
                "Enter your password:",
                "Login",
                JOptionPane.QUESTION_MESSAGE);

        // Check if the user canceled
        if (password == null) {
            return null;
        }

        // Attempt login
        boolean loginSuccess = userService.loginUser(username, password);

        if (loginSuccess) {
            JOptionPane.showMessageDialog(null,
                    "Login successful! Welcome, " + username + "!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            return username;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Login failed. Please check your credentials.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
package com.chatapp.ui;

import com.chatapp.service.UserService;

import javax.swing.JOptionPane;

/**
 * This class manages the user interface for registration.
 */
public class RegisterUI {

    /**
     * Displays the registration dialog.
     *
     * @param userService The user service for registration
     * @return true if registration is successful, false otherwise
     */
    public static boolean showRegisterDialog(UserService userService) {
        String username = JOptionPane.showInputDialog(null,
                "Choose a username (max 5 characters with an underscore):",
                "Registration",
                JOptionPane.QUESTION_MESSAGE);

        // Check if the user canceled
        if (username == null) {
            return false;
        }

        String password = JOptionPane.showInputDialog(null,
                "Choose a password (min 8 characters with uppercase, digit, and special character):",
                "Registration",
                JOptionPane.QUESTION_MESSAGE);

        // Check if the user canceled
        if (password == null) {
            return false;
        }

        String cellNumber = JOptionPane.showInputDialog(null,
                "Enter your cell phone number (format: +27XXXXXXXXX):",
                "Registration",
                JOptionPane.QUESTION_MESSAGE);

        // Check if the user canceled
        if (cellNumber == null) {
            return false;
        }

        // Attempt registration
        String result = userService.registerUser(username, password, cellNumber);

        if (result.startsWith("Registration successful")) {
            JOptionPane.showMessageDialog(null,
                    result,
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Registration errors:\n" + result,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
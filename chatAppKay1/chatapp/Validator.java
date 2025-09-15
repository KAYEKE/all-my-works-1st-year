package com.chatapp.util;

import java.util.regex.Pattern;


import java.util.regex.Pattern;


import java.util.regex.Pattern;

/**
 * This class provides validation methods for user information
 * such as username, password, and cell phone number.
 */
public class Validator {

    /**
     * Checks if the username is valid.
     * A valid username must contain an underscore and
     * not exceed 5 characters.
     *
     * @param username The username to check
     * @return true if the username is valid, false otherwise
     */
    public static boolean checkUsername(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }

        // Check length
        if (username.length() > 5) {
            return false;
        }

        // Check for underscore
        return username.contains("_");
    }

    /**
     * Checks the password complexity.
     * A valid password must:
     * - Have at least 8 characters
     * - Contain at least one uppercase letter
     * - Contain at least one digit
     * - Contain at least one special character
     *
     * @param password The password to check
     * @return true if the password is sufficiently complex, false otherwise
     */
    public static boolean checkPasswordComplexity(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check length
        if (password.length() < 8) {
            return false;
        }

        // Check for uppercase letter
        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            return false;
        }

        // Check for digit
        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            return false;
        }

        // Check for special character
        return Pattern.compile("[^A-Za-z0-9]").matcher(password).find();
    }

    /**
     * Checks if the cell phone number is in a valid South African format.
     * The format must be +27 followed by 9 digits.
     *
     * @param cellNumber The cell phone number to check
     * @return true if the format is valid, false otherwise
     */
    public static boolean checkCellNumber(String cellNumber) {
        if (cellNumber == null || cellNumber.isEmpty()) {
            return false;
        }

        // Format: +27 followed by 9 digits
        return Pattern.compile("^\\+27\\d{9}$").matcher(cellNumber).matches();
    }

    /**
     * Generates an error message for an invalid username.
     *
     * @return Error message for an invalid username
     */
    public static String getUsernameErrorMessage() {
        return "Username must contain an underscore (_) and not exceed 5 characters.";
    }

    /**
     * Generates an error message for a non-complex password.
     *
     * @return Error message for a non-complex password
     */
    public static String getPasswordErrorMessage() {
        return "Password must be at least 8 characters long and contain at least " +
                "one uppercase letter, one digit, and one special character.";
    }

    /**
     * Generates an error message for an invalid cell phone number.
     *
     * @return Error message for an invalid cell phone number
     */
    public static String getCellNumberErrorMessage() {
        return "Cell phone number must be in the format +27 followed by 9 digits.";
    }
}
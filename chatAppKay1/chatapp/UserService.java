package com.chatapp.service;

import com.chatapp.model.User;
import com.chatapp.util.Validator;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This class provides user management services
 * such as registration and login.
 */
public class UserService {
    private List<User> users;

    /**
     * Default constructor
     */
    public UserService() {
        this.users = new ArrayList<>();
    }

    /**
     * Registers a new user in the system.
     *
     * @param username The username
     * @param password The password
     * @param cellNumber The cell phone number
     * @return A success or error message
     */
    public String registerUser(String username, String password, String cellNumber) {
        StringBuilder errorMessage = new StringBuilder();

        // Validate username
        if (!Validator.checkUsername(username)) {
            errorMessage.append(Validator.getUsernameErrorMessage()).append("\n");
        }

        // Validate password
        if (!Validator.checkPasswordComplexity(password)) {
            errorMessage.append(Validator.getPasswordErrorMessage()).append("\n");
        }

        // Validate cell phone number
        if (!Validator.checkCellNumber(cellNumber)) {
            errorMessage.append(Validator.getCellNumberErrorMessage()).append("\n");
        }

        // Check if the user already exists
        if (findUserByUsername(username).isPresent()) {
            errorMessage.append("This username is already taken.\n");
        }

        // If there are errors, return them
        if (errorMessage.length() > 0) {
            return errorMessage.toString();
        }

        // Create and add the new user
        User newUser = new User(username, password, cellNumber);
        users.add(newUser);

        return "Registration successful for " + username + "!";
    }

    /**
     * Logs in an existing user.
     *
     * @param username The username
     * @param password The password
     * @return true if login is successful, false otherwise
     */
    public boolean loginUser(String username, String password) {
        Optional<User> userOptional = findUserByUsername(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(password)) {
                user.setLoggedIn(true);
                return true;
            }
        }

        return false;
    }

    /**
     * Logs out a user.
     *
     * @param username The username to log out
     */
    public void logoutUser(String username) {
        findUserByUsername(username).ifPresent(user -> user.setLoggedIn(false));
    }

    /**
     * Checks if a user is logged in.
     *
     * @param username The username to check
     * @return true if the user is logged in, false otherwise
     */
    public boolean isUserLoggedIn(String username) {
        Optional<User> userOptional = findUserByUsername(username);
        return userOptional.map(User::isLoggedIn).orElse(false);
    }

    /**
     * Finds a user by their username.
     *
     * @param username The username to search for
     * @return An Optional containing the user if they exist
     */
    public Optional<User> findUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    /**
     * Gets the list of all users.
     *
     * @return The list of users
     */
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    /**
     * Sets the list of users (useful for loading from a file).
     *
     * @param users The new list of users
     */
    public void setUsers(List<User> users) {
        this.users = new ArrayList<>(users);
    }
}

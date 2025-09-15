package com.chatapp.model;

/**
 This class represents a user in the chat system.
 It stores credentials and login state.
 */
public class User {
    private String username;
    private String password;
    private String cellNumber;
    private boolean loggedIn;

    /**
     Default constructor
     */
    public User() {
        this.loggedIn = false;
    }

    /**
     * Parameterized constructor
     *
     * @param username User's username
     * @param password User's password
     * @param cellNumber User's cell phone number
     */
    public User(String username, String password, String cellNumber) {
        this.username = username;
        this.password = password;
        this.cellNumber = cellNumber;
        this.loggedIn = false;
    }

    // Getters and Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", cellNumber='" + cellNumber + '\'' +
                ", loggedIn=" + loggedIn +
                '}';
    }
}
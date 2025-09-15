import javax.swing.JOptionPane;


// User authentication class

public class UserAuth {
    private String username;
    private String password;

    /**
     * Constructor for UserAuth class
     * @param username User's username
     * @param password User's password
     */
    public UserAuth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Validates user login credentials
     * @return True if login is successful, false otherwise
     */
    public boolean login() {
        // This is a simple implementation for demonstration
        // In a real application, this would connect to a database or service
        if (username != null && password != null &&
                !username.isEmpty() && !password.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Login successful. Welcome " + username + "!");
            return true;
        }
        return false;
    }
}
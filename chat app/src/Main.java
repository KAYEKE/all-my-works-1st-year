import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username;
        String password;

        System.out.println("Username required must include '_' and be no more than 5 characters long");
        username = sc.nextLine();

        if (username.contains("_") && username.length() <= 5) {
            System.out.println("Username accepted");
        } else {
            System.out.println("Username is invalid, username must include '_' and be no more than 5 characters long");
        }

        System.out.println("Enter your password");
        password = sc.nextLine();

        if (isValidPassword(password)) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Please try again, the password is invalid or not correct enough. Password must include at least 8 characters, including at least one uppercase letter, one lowercase letter, and one number.");
        }
    }
    private static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }
        return hasUppercase && hasLowercase && hasDigit;
    }
}


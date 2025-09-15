import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String username;
        String email;
        String password;

        System.out.println("please enter your name");
        name = scanner.nextLine();
        System.out.println("please enter your username");
        username = scanner.nextLine();
        System.out.println("please enter your email");
        email = scanner.nextLine();
        System.out.println("please enter your password");
        password = scanner.nextLine();

        if (password.length() >= 8 && password.matches(".*[!@#$%^&*(),.?\":{}<>].*")) {
            System.out.println("password is valid");
        } else {
            System.out.println("password incorrect please try again");
        }
    }
}
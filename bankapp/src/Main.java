import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pin= 1234;
        int Balance;
        int UserPin = 0;

        System.out.println("Enter the Pin");
        pin = scanner.nextInt();
        System.out.println("Enter the Balance");
        Balance = scanner.nextInt();

        while (UserPin != pin) {
            System.out.println("The pin is incorrect, please write the correct pin");
            UserPin = scanner.nextInt();
        }
        int choice = 0;
        while (choice == 4) {
        System.out.println("choose option");
        System.out.println("check Balance");
        System.out.println("deposit money");
        System.out.println("withdral money");
        System.out.println("exit");




    }
}
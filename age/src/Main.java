import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value;
        int total = 0;
        int count = 0;
        while (count < 2) {
            System.out.println("Enter a number");
            value = scanner.nextInt();
            total = total + value;
            count = count + 1;
        }
        System.out.println("The total is" + total);
        }
    }


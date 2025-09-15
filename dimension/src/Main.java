import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of the rectangle:");
        int length = scanner.nextInt();
        System.out.println("Enter the width of the rectangle:");
        int width = scanner.nextInt();



        double perimeter = calculatePerimeter(length, width);
        System.out.println("The perimeter of the rectangle is: " + perimeter);
    }

    public static double calculatePerimeter(int length, int width) {
        return (2 * length) + (2 * width);
    }
}

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of hours");
        int hours = sc.nextInt();
        int rate = 360;
        double grossPay=hours*rate;
        System.out.println("The grosPay is: " +grossPay);



    }
}
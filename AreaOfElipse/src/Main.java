import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pi= (int) 3.14;
        int Area=0;
        System.out.println("Enter the major radius of the ellipse:");
        int r1=sc.nextInt();
        System.out.println("Enter the minor radius of the ellipse:");
        int r2=sc.nextInt();
        Area=pi*(r1*r2);
        System.out.println("The area of the ellipse is:"+Area);
    }
    }

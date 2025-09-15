import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        double radius;
        double area;
        double Pi = 3.142;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of the circle:");
        radius = sc.nextDouble();
        area = CalculateArea(Pi,radius);
        System.out.println("Area of the circle:"+ area);

    }
        public static double CalculateArea(double Pi,double radius) {
            return (Pi *radius);



    }

}
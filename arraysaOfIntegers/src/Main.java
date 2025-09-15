
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int[] students = new int[10];


        for (int i = 0; i < students.length; i++) {
            System.out.println("enter marks of 10 students ");
            students[i] = sc.nextInt();

            if (students[i] %2==1) {
                System.out.println("Mark divisible by 2:"+students[i]);

            }
            System.out.println("The mark is:" + Arrays.toString(students));
        }
    }
}

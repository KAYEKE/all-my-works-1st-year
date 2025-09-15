
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] colors = new String[5];
        for (int i = 0; i < colors.length; i++) {
            System.out.println("enter colours ");
            colors[i] = sc.nextLine();
        }
        System.out.println("The mark is:" + Arrays.toString(colors));

    }
}
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 3;
        String[] ITEMS = {"pencil", "rubber", "paintbrush"};
        String item;
        int[] PRICES = {3, 5, 10};
        int sub = 0;
        String searchItem = sc.nextLine();
        String foundit = "N";
        String price;


        System.out.println("Enter item to search for (pencil, rubber, paintbrush):");
        item = sc.nextLine();


        for (int i = 0; i < item.length(); i++) {
            if (searchItem.equalsIgnoreCase(ITEMS[i])) {
                foundit = "N";
                while (sub < size) {
                    if (item.equals(ITEMS[sub])) {
                        foundit = "Y";
                        price = String.valueOf((PRICES[sub]));
                    }
                    sub++;
                }
                if (foundit.equals("Y")) {
                    System.out.println("price is:" + PRICES);
                }
                System.out.println("Item not found");
            }
        }
    }
}
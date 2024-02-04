import java.util.Scanner;

public class ShoppingCartPrinter {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Item 1");
        System.out.println("Enter the item name:");
        String itemName = scnr.nextLine();
        System.out.println("Enter the item price:");
        int itemPrice = scnr.nextInt();
        System.out.println("Enter the item quantity:");
        int itemQuantity = scnr.nextInt();

        scnr.nextLine();

        System.out.println("\nItem 2");
        System.out.println("Enter the item name:");
        String itemName2 = scnr.nextLine();
        System.out.println("Enter the item price:");
        int itemPrice2 = scnr.nextInt();
        System.out.println("Enter the item quantity:");
        int itemQuantity2 = scnr.nextInt();

        ItemToPurchase item1 = new ItemToPurchase(itemName, itemPrice, itemQuantity);
        ItemToPurchase item2 = new ItemToPurchase(itemName2, itemPrice2, itemQuantity2);

        System.out.println("\nTOTAL COST");
        System.out.printf("%s %d @ $%d = $%d%n", item1.getName(), item1.getQuantity(), item1.getPrice(), (item1.getPrice() * item1.getQuantity()));
        System.out.printf("%s %d @ $%d = $%d%n", item2.getName(), item2.getQuantity(), item2.getPrice(), (item2.getPrice() * item2.getQuantity()));
        System.out.println();
        System.out.printf("Total: $%d%n", ((item1.getPrice() * item1.getQuantity()) + (item2.getPrice() * item2.getQuantity())));

    }
}

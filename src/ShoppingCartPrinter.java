import java.util.Scanner;

public class ShoppingCartPrinter {
    static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        ItemToPurchase item1 = getItemDetails("Item 1");
        System.out.println();
        ItemToPurchase item2 = getItemDetails("Item 2");

        printTotalCost(item1, item2);
    }

    public static ItemToPurchase getItemDetails(String itemLabel) {
        System.out.println(itemLabel);
        System.out.println("Enter the item name:");
        String itemName = scnr.nextLine();
        System.out.println("Enter the item price:");
        int itemPrice = scnr.nextInt();
        scnr.nextLine();  // consume newline left-over
        System.out.println("Enter the item quantity:");
        int itemQuantity = scnr.nextInt();
        scnr.nextLine();  // consume newline left-over

        return new ItemToPurchase(itemName, itemPrice, itemQuantity);
    }

    public static void printItemCost(ItemToPurchase item) {
        System.out.printf("%s %d @ $%d = $%d%n", item.getName(), item.getQuantity(), item.getPrice(), (item.getPrice() * item.getQuantity()));
    }

    public static void printTotalCost(ItemToPurchase item1, ItemToPurchase item2) {
        System.out.println("TOTAL COST");
        printItemCost(item1);
        printItemCost(item2);
        System.out.printf("Total: $%d%n", ((item1.getPrice() * item1.getQuantity()) + (item2.getPrice() * item2.getQuantity())));
    }
}
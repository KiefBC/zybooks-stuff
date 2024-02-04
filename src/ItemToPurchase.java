public class ItemToPurchase {

    private String itemName;
    private int itemPrice;
    private int itemQuantity;

    public ItemToPurchase() {
        this.itemName = "none";
        this.itemPrice = 0;
        this.itemQuantity = 0;
    }

    public ItemToPurchase(String name, int price, int quantity) {
        this.itemName = name;
        this.itemPrice = price;
        this.itemQuantity = quantity;
    }

    public void setName(String name) {
        this.itemName = name;
    }

    public void setPrice(int price) {
        this.itemPrice = price;
    }

    public void setQuantity(int quantity) {
        this.itemQuantity = quantity;
    }

    public String getName() {
        return itemName;
    }

    public int getPrice() {
        return itemPrice;
    }

    public int getQuantity() {
        return itemQuantity;
    }
}
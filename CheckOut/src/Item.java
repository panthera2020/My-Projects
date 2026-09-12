public class Item {
    private String itemName;
    private double priceOfItem;
    private int quantity;

    public void setItemName(String itemName) {this.itemName = itemName;}

    public void setPriceOfItem(double priceOfItem) {this.priceOfItem = priceOfItem;}

    public void setQuantity(int quantity) {this.quantity = quantity;}

    public String getItemName() {return itemName;}

    public double getPriceOfItem() {return priceOfItem;}

    public int getQuantity() {return quantity;}

    public double totalPrice() {
        return priceOfItem * quantity;
    }
}

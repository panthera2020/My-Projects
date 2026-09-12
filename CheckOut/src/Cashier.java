import java.util.ArrayList;

public class Cashier {
    private String cashierName;
    private ArrayList<Item> items = new ArrayList<>();

    public Cashier(String cashierName) {this.cashierName = cashierName;}

    public String getCashierName() {return cashierName;}

    public void addItem(String item, double price , int quantity) {
        Item newItem = new Item();
        newItem.setItemName(item);
        newItem.setPriceOfItem(price);
        newItem.setQuantity(quantity);
        items.add(newItem);
    }

    public ArrayList<Item> getItems() {return items;}

    public double getSubTotal() {
        double total = 0;
        for(Item item : items) {total += item.totalPrice();}
        return (total * 100) / 100;
    }

    public double getDiscount(double discount) {return getSubTotal() * (((discount / 100) * 100) / 100);}

    public double getVat() {return getSubTotal() * ((( 7.5 / 100) * 100) / 100);}

    public double getTotalBill(double discount) {return getSubTotal() - getDiscount(discount) + getVat();}

    public double getChange(double amount, double discount) {return amount - getTotalBill(discount);}
}

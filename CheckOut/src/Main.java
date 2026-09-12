import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Cashier cashier = new Cashier("Donald");
        LocalDateTime dateTime = LocalDateTime.now();

        IO.println("What is the customer name? ");
        String customerName = input.nextLine();

        String userChoice = "";
        while(!userChoice.equalsIgnoreCase("no")){
            IO.println("What did user buy? ");
            String itemName = input.nextLine();
            IO.println("How many pieces?");
            int quantity = input.nextInt();
            IO.println("How much per unit? ");
            double price = input.nextDouble();
            cashier.addItem(itemName,price,quantity);
            input.nextLine();
            IO.println("Add more items? (yes/no)");
            userChoice = input.nextLine();
        }

        IO.println();
        IO.println("How much discount will customer get?");
        double discount = input.nextDouble();

        String storeMessage = """
SEMICOLON STORES
MAIN BRANCH
LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
TEL NO: 03293828343\s""";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String date = dateTime.format(formatter);
        IO.println();
        IO.println(storeMessage);
        IO.println("Date: " + date);
        IO.println("Cashier: " + cashier.getCashierName());
        IO.println("Customer Name: " + customerName);
        IO.println("===========================================================================");
        System.out.printf("%-15s %5s %10s %10s%n", "ITEMS", "QUANTITY", "PRICE", "TOTAL()NGN");
        IO.println("---------------------------------------------------------------------------");
        ArrayList<Item> itemsList = cashier.getItems();
        for(Item item : itemsList){
            System.out.printf("%-15s %5s %10s %10s%n", item.getItemName(), item.getQuantity(), item.getPriceOfItem(), item.totalPrice());
        }
        IO.println();
        IO.println("---------------------------------------------------------------------------");
        System.out.printf("%25s %5s%n", "Sub Total: ", cashier.getSubTotal());
        System.out.printf("%25s %5s%n", "Discount: ", cashier.getDiscount(discount));
        System.out.printf("%25s %5s%n", "VAT @ 7.5%: ", cashier.getVat());
        IO.println("===========================================================================");
        System.out.printf("%25s %5s%n", "Bill Total: ", cashier.getTotalBill(discount));
        IO.println("===========================================================================");
        IO.println("THIS IS NOT A RECEIPT, KINDLY PAY " + cashier.getTotalBill(discount));
        IO.println("===========================================================================");

        IO.println();
        IO.println("How much did the customer give to you? ");
        double amountGiven = input.nextDouble();

        IO.println();
        IO.println(storeMessage);
        IO.println("Date: " + date);
        IO.println("Cashier: " + cashier.getCashierName());
        IO.println("Customer Name: " + customerName);
        IO.println("===========================================================================");
        System.out.printf("%-15s %5s %10s %10s%n", "ITEMS", "QUANTITY", "PRICE", "TOTAL()NGN");
        IO.println("---------------------------------------------------------------------------");
        for(Item item : itemsList){
            System.out.printf("%-15s %5s %10s %10s%n", item.getItemName(), item.getQuantity(), item.getPriceOfItem(), item.totalPrice());
        }
        IO.println();
        IO.println("---------------------------------------------------------------------------");
        System.out.printf("%25s %5s%n", "Sub Total: ", cashier.getSubTotal());
        System.out.printf("%25s %5s%n", "Discount: ", cashier.getDiscount(discount));
        System.out.printf("%25s %5s%n", "VAT @ 7.5%: ", cashier.getVat());
        IO.println("===========================================================================");
        System.out.printf("%25s %5s%n", "Bill Total: ", cashier.getTotalBill(discount));
        System.out.printf("%25s %5s%n", "Amount: ", amountGiven);
        System.out.printf("%25s %5s%n", "Balance: ", cashier.getChange(amountGiven,discount));
        IO.println("===========================================================================");
        IO.println("        THANK YOU FOR YOUR PATRONAGE        ");
        IO.println("===========================================================================");

    }
}

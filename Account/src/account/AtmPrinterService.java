package account;

public class AtmPrinterService {
    public void printSuccess(String message) {
        IO.println(message);
        IO.println("Thank you for Banking with us....");
        IO.println();
    }

    public void printError(String message) {
        IO.println("Error: " + message);
        IO.println();
    }

    public void printBalance(String name, int balance) {
        IO.println("Mr " + name);
        IO.println("Your balance is " + balance);
        IO.println("Thank you for Banking with us....");
        IO.println();
    }
}

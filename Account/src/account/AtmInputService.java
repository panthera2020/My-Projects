package account;

import java.util.Scanner;

public class AtmInputService {
    private Scanner input;

    public AtmInputService(Scanner input) { this.input = input; }

    public int getAccountNumber() {
        IO.println("Enter account number: ");
        return input.nextInt();
    }

    public int getAmount() {
        IO.println("Enter amount: ");
        return input.nextInt();
    }

    public String getPassword() {
        IO.println("Enter password: ");
        return input.nextLine();
    }

    public String getConfirmation(String message) {
        IO.println(message + " (Yes/No)");
        return input.nextLine();
    }

    public void clearBuffer() {
        input.nextLine();
    }
}
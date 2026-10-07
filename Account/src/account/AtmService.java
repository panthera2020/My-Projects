package account;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AtmService {
    private Bank bank;
    private AtmInputService inputService;
    private AtmPrinterService printerService;

    public AtmService(Bank bank, Scanner input) {
        this.bank = bank;
        this.inputService = new AtmInputService(input);
        this.printerService = new AtmPrinterService();
    }

    public void handleDeposit() {
        String depositChoice = "";
        while (!depositChoice.equalsIgnoreCase("Yes")) {
            try {
                String accountNumber = inputService.getAccountNumber();
                int amount = inputService.getAmount();
                inputService.clearBuffer();
                String name = bank.checkAccountName(accountNumber);
                depositChoice = inputService.getConfirmation("Deposit account name: " + name);
                if (depositChoice.equalsIgnoreCase("Yes")) {
                    bank.deposit(amount, accountNumber);
                    printerService.printSuccess(amount + " deposited");
                }
            } catch (IllegalArgumentException e) {
                printerService.printError(e.getMessage());
                depositChoice = "";
            } catch (InputMismatchException e) {
                inputService.clearBuffer();
                printerService.printError("Invalid input. Please try again.");
                depositChoice = "";
            }
        }
    }

    public void handleWithdraw() {
        boolean withdrawn = false;
        while (!withdrawn) {
            try {
                String accountNumber = inputService.getAccountNumber();
                int amount = inputService.getAmount();
                inputService.clearBuffer();
                String password = inputService.getPassword();
                bank.withdraw(amount, accountNumber, password);
                printerService.printSuccess(amount + " withdrawn");
                withdrawn = true;
            } catch (IllegalArgumentException e) {
                printerService.printError(e.getMessage());
            } catch (InputMismatchException e) {
                inputService.clearBuffer();
                printerService.printError("Invalid input. Please try again.");
            }
        }
    }

    public void handleTransfer() {
        String transferChoice = "";
        while (!transferChoice.equalsIgnoreCase("Yes")) {
            try {
                String senderAccountNumber = inputService.getAccountNumber();
                IO.println("For recipient's: ");
                String recipientAccountNumber = inputService.getAccountNumber();
                int amount = inputService.getAmount();
                inputService.clearBuffer();
                String recipientName = bank.checkAccountName(recipientAccountNumber);
                transferChoice = inputService.getConfirmation("Recipient account name: " + recipientName);
                if (transferChoice.equalsIgnoreCase("Yes")) {
                    String password = inputService.getPassword();
                    bank.transfer(amount, senderAccountNumber, recipientAccountNumber, password);
                    printerService.printSuccess("Transfer successful");
                }
            } catch (IllegalArgumentException e) {
                printerService.printError(e.getMessage());
                transferChoice = "";
            } catch (InputMismatchException e) {
                inputService.clearBuffer();
                printerService.printError("Invalid input. Please try again.");
                transferChoice = "";
            }
        }
    }

    public void handleCheckBalance() {
        boolean checked = false;
        while (!checked) {
            try {
                String accountNumber = inputService.getAccountNumber();
                inputService.clearBuffer();
                String password = inputService.getPassword();
                String name = bank.checkAccountName(accountNumber);
                int balance = bank.checkBalance(accountNumber, password);
                printerService.printBalance(name, balance);
                checked = true;
            } catch (IllegalArgumentException e) {
                printerService.printError(e.getMessage());
            } catch (InputMismatchException e) {
                inputService.clearBuffer();
                printerService.printError("Invalid input. Please try again.");
            }
        }
    }
}
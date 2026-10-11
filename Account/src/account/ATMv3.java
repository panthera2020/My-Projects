package account;

import javax.swing.*;
import java.util.InputMismatchException;

public class ATMv3 {
    private static final Bank gtbAtm = Banks.getNibs().findBank(BankCode.GUARANTY_TRUST_BANK);

    public static void main(String[] args) {
        goToMainMenu();
    }

    private static void goToMainMenu() {
        String mainMenu = """
                ======================================
                        WELCOME TO GTB ATM
                ======================================
                TO CREATE ACCOUNT       -> PRESS 1
                TO DEPOSIT              -> PRESS 2
                TO WITHDRAW             -> PRESS 3
                TO TRANSFER             -> PRESS 4
                TO CHECK BALANCE        -> PRESS 5
                ======================================
                TO EXIT                 -> PRESS 0
                ======================================
                """;
        String userChoice = input(mainMenu);
        switch (userChoice) {
            case "1" -> createAccount();
            case "2" -> deposit();
            case "3" -> withdraw();
            case "4" -> transfer();
            case "5" -> checkBalance();
            case "0" -> exit();
            default -> print("Wrong input!");
        }
    }

    private static void exit() {
        print("Thank you for using Banking with us....");
        System.exit(0);
    }

    private static void transfer() {
        try {
            print("Sender Account");
            String senderAccountNumber = requestAccountNumber();
            print("Receiver Account");
            String receiverAccountNumber = requestAccountNumber();
            int amount = requestAmount();
            String senderPin = requestPin();
            gtbAtm.transfer(amount,senderAccountNumber,receiverAccountNumber,senderPin);
            print("Transfer complete!");
        }
        catch (IllegalArgumentException | InputMismatchException e) {
            print(e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void checkBalance() {
        try {
            String userAccountNumber = requestAccountNumber();
            String userPin = requestPin();
            int balance = gtbAtm.checkBalance(userAccountNumber, userPin);
            print("Your account balance is " + balance);
        }
        catch (IllegalArgumentException | InputMismatchException e) {
            print(e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void withdraw() {
        try {
            String userAccountNumber = requestAccountNumber();
            String userPin = requestPin();
            int amount = requestAmount();
            gtbAtm.withdraw(amount,userAccountNumber,userPin);
            print(amount + " withdrawn successfully!");
            print("New balance: " + gtbAtm.checkBalance(userAccountNumber, userPin));
        }
        catch (IllegalArgumentException | InputMismatchException e) {
            print(e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void deposit() {
        try {
            String userAccountNumber = requestAccountNumber();
            int amount = requestAmount();
            gtbAtm.deposit(amount, userAccountNumber);
            print(amount + " deposited successfully!");
        }
        catch (IllegalArgumentException | InputMismatchException e) {
            print(e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void createAccount() {
        try {
            String userName = input("Enter your name: ");
            String userPin = requestPin();
            String userAccountNumber = gtbAtm.createAccount(userName, userPin);
            print("Account created successfully!");
            print("Account number: " + userAccountNumber);
        }
        catch (IllegalArgumentException e) {
            print(e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }
    private static String input(String prompt) {return JOptionPane.showInputDialog(null, prompt);}

    private static String requestAccountNumber() { return input("Enter Account Number: ");}

    private static String requestPin() { return input("Enter PIN: ");}

    private static int requestAmount() { return Integer.parseInt(input("Enter Amount "));}

    public static void print(String message){ JOptionPane.showMessageDialog(null,message);}
}

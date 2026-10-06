package account;

import javax.swing.*;

public class ATMv2 {
    private static Bank gtbBank = new Bank("058");

    public static void main(String[] args) {
        goToMainMenu();
    }

    private static void goToMainMenu() {
        String mainMenu = """
                ======================================
                WELCOME TO ANIGILAJE MICROFINANCE BANK
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
            IO.println("Sender Account");
            int senderAccountNumber = requestAccountNumber();
            IO.println("Receiver Account");
            int receiverAccountNumber = requestAccountNumber();
            int amount = requestAmount();
            String senderPin = requestPin();
            gtbBank.transfer(amount,senderAccountNumber,receiverAccountNumber,senderPin);
            print("Transfer complete!");
        }
        catch (IllegalArgumentException e) {
            print(e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void checkBalance() {
        try {
            int userAccountNumber = requestAccountNumber();
            String userPin = requestPin();
            int balance = gtbBank.checkBalance(userAccountNumber, userPin);
            print("Your account balance is " + balance);
        }
        catch (IllegalArgumentException e) {
            print(e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void withdraw() {
        try {
            int userAccountNumber = requestAccountNumber();
            String userPin = requestPin();
            int amount = requestAmount();
            gtbBank.withdraw(amount, userAccountNumber, userPin);
            print(amount + " withdrawn successfully!");
            print("New balance: " + gtbBank.checkBalance(userAccountNumber, userPin));
        }
        catch (IllegalArgumentException e) {
            print(e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void deposit() {
        try {
            int userAccountNumber = requestAccountNumber();
            int amount = requestAmount();
            gtbBank.deposit(amount,userAccountNumber);
        }
        catch (IllegalArgumentException e) {
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
            gtbBank.createAccount(userName, userPin);
        }
        catch (IllegalArgumentException e) {
            print(e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static String input(String prompt) { return JOptionPane.showInputDialog(prompt);}

    private static int requestAccountNumber() { return Integer.parseInt(input("Enter Account Number: "));}

    private static String requestPin() { return input("Enter PIN: ");}

    private static int requestAmount() { return Integer.parseInt(input("Enter Amount "));}

    public static void print(String message){IO.print(message);}
}

package account;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.List;

public class ATMv2 {
    private static Bank gtbBank = new Bank(BankCode.GUARANTY_TRUST_BANK);
    private static Banks cbn = new Banks();

    public static void main(String[] args) {
        addBanks();
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
            String senderAccountNumber = requestAccountNumber();
            IO.println("Receiver Account");
            String receiverAccountNumber = requestAccountNumber();
            int amount = requestAmount();
            String senderPin = requestPin();
            gtbBank.transfer(amount,senderAccountNumber,receiverAccountNumber,senderPin);
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
            int balance = gtbBank.checkBalance(userAccountNumber, userPin);
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
            gtbBank.withdraw(amount, userAccountNumber, userPin);
            print(amount + " withdrawn successfully!");
            print("New balance: " + gtbBank.checkBalance(userAccountNumber, userPin));
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
            gtbBank.deposit(amount,userAccountNumber);
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
            int bankSelection = selectBank();
            String userName = input("Enter your name: ");
            String userPin = requestPin();
            switch (bankSelection) {
                case 1 ->
            }
            String userAccountNumber = gtbBank.createAccount(userName, userPin);
            print("Account created successfully!");
            print("Account number: " + userAccountNumber);
        }
        catch (IllegalArgumentException | InputMismatchException e) {
            print(e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static int selectBank() {
        List<Bank> registeredBanks = cbn.getNumberOfRegisteredBanks();
        int counter = 1;
        for(Bank eachBank :  registeredBanks) {
            print("FOR " + eachBank.getBankName() + " PRESS " + counter);
            counter++;
        }
        return Integer.parseInt(input("Please enter a number between 1 and " + registeredBanks.size()));
    }

    private static void addBanks() {
        for(BankCode registeredBank : BankCode.values()) {
            Bank bank = new Bank(registeredBank);
            cbn.add(bank);
        }
    }

    private static String input(String prompt) { return JOptionPane.showInputDialog(prompt);}

    private static String requestAccountNumber() { return input("Enter Account Number: ");}

    private static String requestPin() { return input("Enter PIN: ");}

    private static int requestAmount() { return Integer.parseInt(input("Enter Amount "));}

    public static void print(String message){JOptionPane.showMessageDialog(null,message);}
}

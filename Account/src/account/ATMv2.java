package account;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ATMv2 {
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
            cbn.transfer(amount,senderAccountNumber,receiverAccountNumber,senderPin);
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
            Bank userBank = cbn.findBankOf(userAccountNumber);
            int balance = userBank.checkBalance(userAccountNumber, userPin);
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
            Bank userBank = cbn.findBankOf(userAccountNumber);
            userBank.withdraw(amount, userAccountNumber, userPin);
            print(amount + " withdrawn successfully!");
            print("New balance: " + userBank.checkBalance(userAccountNumber, userPin));
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
            Bank userBank = cbn.findBankOf(userAccountNumber);
            userBank.deposit(amount,userAccountNumber);
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
            int selectedBank = selectBank();
            String userName = input("Enter your name: ");
            String userPin = requestPin();
            registerAccount(selectedBank, userName, userPin);
        }
        catch (IllegalArgumentException | InputMismatchException e) {
            print(e.getMessage());
        }
        finally {
            goToMainMenu();
        }
    }

    private static void registerAccount(int bankSelected, String userName, String userPin) {
        List<Bank> registeredBank = cbn.getRegisteredBanks();
        String userAccountNumber = "";
        userAccountNumber = registeredBank.get(bankSelected - 1).createAccount(userName, userPin);
        print("Account created successfully!");
        print("Account number: " + userAccountNumber);
    }

    private static int selectBank() {
        List<Bank> registeredBanks = cbn.getRegisteredBanks();
        int counter = 1;
        for(Bank eachBank :  registeredBanks) {
            print("FOR " + eachBank.getBankName() + " PRESS " + counter);
            counter++;
        }
        int selectedBank = Integer.parseInt(input("Please enter a number between 1 and " + registeredBanks.size()));
        validate(selectedBank, registeredBanks);
        return selectedBank;
    }

    private static void validate(int selectedBank, List<Bank> registeredBanks) {
        if(selectedBank < 1 || selectedBank > registeredBanks.size()) throw new InputMismatchException("Please enter a number between 1 and " + registeredBanks.size());
    }

    private static void addBanks() {
        for(BankCode registeredBank : BankCode.values()) {
            Bank bank = new Bank(registeredBank);
            cbn.add(bank);
        }
    }

    private static String input(String prompt) {
        IO.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String requestAccountNumber() { return input("Enter Account Number: ");}

    private static String requestPin() { return input("Enter PIN: ");}

    private static int requestAmount() { return Integer.parseInt(input("Enter Amount "));}

    public static void print(String message){ IO.println(message);}
}

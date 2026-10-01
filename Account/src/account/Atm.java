package account;

import java.util.Scanner;

public class Atm {
    static void main() {
        Bank bank = new Bank();
        bank.createAccount("Bola","5555");
        bank.createAccount("Tola","2222");
        bank.createAccount("Donald","3333");
        Scanner input = new Scanner(System.in);

        String welcomeMessage = """
                ======================================
                WELCOME TO ANIGILAJE MICROFINANCE BANK
                ======================================
                TO DEPOSIT              -> PRESS 1
                TO WITHDRAW             -> PRESS 2
                TO TRANSFER             -> PRESS 3
                TO CHECK BALANCE        -> PRESS 4
                ======================================
                TO EXIT                 -> PRESS 0
                ======================================
                """;
        String userMenuChoice = "";
        while (!userMenuChoice.equals("0")) {
            IO.println(welcomeMessage);
            userMenuChoice = input.nextLine();
            if (userMenuChoice.equals("1")) {
                String depositChoice = "";
                while (!depositChoice.equalsIgnoreCase("Yes")) {
                    try {
                        IO.println("Enter account number: ");
                        int accountNumber = input.nextInt();
                        IO.println("Enter amount: ");
                        int amount = input.nextInt();
                        String depositAccountName = bank.checkAccountName(accountNumber);
                        input.nextLine();
                        IO.println("Deposit account name: " + depositAccountName + " (Yes/No)");
                        depositChoice = input.nextLine();
                        if (depositChoice.equalsIgnoreCase("Yes")) {
                            bank.deposit(amount, accountNumber);
                            IO.println("Thank you for Banking with us....");
                        }
                    } catch (IllegalArgumentException e) {
                        IO.println("Error: " + e.getMessage());
                        input.nextLine();
                    }
                }
            }else if (userMenuChoice.equals("2")) {
                boolean withdrawn = false;
                while (!withdrawn) {
                    try {
                        IO.println("Enter account number: ");
                        int accountNumber = input.nextInt();
                        IO.println("Enter amount: ");
                        int amount = input.nextInt();
                        IO.println("Enter password: ");
                        input.nextLine();
                        String password = input.nextLine();
                        bank.withdraw(amount, accountNumber, password);
                        IO.println("Thank you for Banking with us....");
                        withdrawn = true;
                    } catch (IllegalArgumentException e) {
                        IO.println("Error: " + e.getMessage());
                        input.nextLine();
                    }
                }
            }else if (userMenuChoice.equals("3")) {
                String transferChoice = "";
                while (!transferChoice.equalsIgnoreCase("Yes")) {
                    try {
                        IO.println("Enter sender account number: ");
                        int senderAccountNumber = input.nextInt();
                        IO.println("Enter recipient's account number: ");
                        int recipientAccountNumber = input.nextInt();
                        IO.println("Enter amount: ");
                        int amount = input.nextInt();
                        input.nextLine();
                        String recipientName = bank.checkAccountName(recipientAccountNumber);
                        IO.println("Recipient account name: " + recipientName + " (Yes/No)");
                        transferChoice = input.nextLine();
                        if (transferChoice.equalsIgnoreCase("Yes")) {
                            IO.println("Enter password: ");
                            String password = input.nextLine();
                            bank.transfer(amount, senderAccountNumber, recipientAccountNumber, password);
                            IO.println("Thank you for Banking with us....");
                        }
                    } catch (IllegalArgumentException e) {
                        IO.println("Error: " + e.getMessage());
                        input.nextLine();
                    }
                }
            }else if (userMenuChoice.equals("4")) {
                boolean checked = false;
                while (!checked) {
                    try {
                        IO.println("Enter account number: ");
                        int accountNumber = input.nextInt();
                        input.nextLine();
                        IO.println("Enter password: ");
                        String password = input.nextLine();
                        IO.println("Mr " + bank.checkAccountName(accountNumber));
                        IO.println("Your balance is " + bank.checkBalance(accountNumber, password));
                        IO.println("Thank you for Banking with us....");
                        checked = true;
                    } catch (IllegalArgumentException e) {
                        IO.println("Error: " + e.getMessage());
                    }
                }
            }
        }
    }
}

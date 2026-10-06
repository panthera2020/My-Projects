package account;

import java.util.Scanner;

public class Atm {
    static void main() {
        Bank bank = new Bank("011");
        bank.createAccount("Bola", "5555");
        bank.createAccount("Tola", "2222");
        bank.createAccount("Donald", "3333");

        Scanner input = new Scanner(System.in);
        AtmService atmService = new AtmService(bank, input);

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
            switch (userMenuChoice) {
                case "1" -> atmService.handleDeposit();
                case "2" -> atmService.handleWithdraw();
                case "3" -> atmService.handleTransfer();
                case "4" -> atmService.handleCheckBalance();
            }
        }
    }
}
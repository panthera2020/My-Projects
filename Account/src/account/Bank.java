package account;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    private int generateAccountNumber() {
        return accounts.size() + 1;
    }

    public void createAccount(String name, String password) {
        Account newAccount = new Account(name, password);
        newAccount.set(generateAccountNumber());
        accounts.add(newAccount);
    }

    public int getNumberOfCustomer() {
        return 1;
    }

    public int checkBalance(int accountNumber, String correctPassword) {
        Account foundAccount = findAccount(accountNumber);
        return foundAccount.checkBalance(correctPassword);
    }

    private Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public void deposit(int amount, int accountNumber, String correctPassword) {
        Account foundAccount = findAccount(accountNumber);
        foundAccount.deposit(amount);
    }

    public void withdraw(int amount, int accountNumber, String correctPassword) {
        Account foundAccount = findAccount(accountNumber);
        foundAccount.withdraw(amount, correctPassword);
    }
}

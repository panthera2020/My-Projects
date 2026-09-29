package account;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    private int generateAccountNumber() { return accounts.size() + 1;}

    public void createAccount(String name, String password) {
        Account newAccount = new Account(name, password);
        newAccount.set(generateAccountNumber());
        accounts.add(newAccount);
    }

    public int getNumberOfCustomer() { return accounts.size(); }

    public int checkBalance(int accountNumber, String correctPassword) {
        validate(accountNumber);
        return findAccount(accountNumber).checkBalance(correctPassword);
    }

    private Account findAccount(int accountNumber) {
        for (Account useraccount : accounts) {
            if (useraccount.getAccountNumber() == accountNumber) { return useraccount;}
        }
        return null;
    }

    public void deposit(int amount, int accountNumber) {
        validate(accountNumber);
        findAccount(accountNumber).deposit(amount);
    }

    public void withdraw(int amount, int accountNumber, String correctPassword) {
        validate(accountNumber);
        findAccount(accountNumber).withdraw(amount, correctPassword);
    }

    public void transfer(int amount, int senderAccountNumber, int receiverAccountNumber, String senderPassword) {
        validate(senderAccountNumber, receiverAccountNumber);
        validate(senderAccountNumber);
        validate(receiverAccountNumber);
        withdraw(amount,senderAccountNumber,senderPassword);
        deposit(amount,receiverAccountNumber);
    }

    private void validate(int senderAccountNumber, int receiverAccountNumber) {
        if(senderAccountNumber == receiverAccountNumber) throw new IllegalArgumentException("Same account number");
    }

    private void validate(int accountNumber) {
        if(findAccount(accountNumber) == null) throw new IllegalArgumentException("Account number not found");
    }
}

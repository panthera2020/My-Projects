package account;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();
    private BankCode bankName;
    private Nuban nuban =  new Nuban();

    public Bank(BankCode bankName) {
        this.bankName = bankName;
    }

    private String generateAccountNumber() {return nuban.create(bankName.getBankCode());}

    public String getBankName(){return bankName.toString();}

    public BankCode getBankCode(){return bankName;}

    public String  createAccount(String name, String password) {
        Account newAccount = new Account(name, password);
        newAccount.set(generateAccountNumber());
        accounts.add(newAccount);
        return newAccount.getAccountNumber();
    }

    public int getNumberOfCustomer() { return accounts.size(); }

    public int checkBalance(String accountNumber, String password) {
        validate(accountNumber);
        return findAccount(accountNumber).checkBalance(password);
    }

    private Account findAccount(String accountNumber) {
        for (Account useraccount : accounts) { if (useraccount.getAccountNumber().equals(accountNumber) ) { return useraccount;}}
        return null;
    }

    public void deposit(int amount, String accountNumber) {
        validate(accountNumber);
        findAccount(accountNumber).deposit(amount);
    }

    public void withdraw(int amount, String accountNumber, String correctPassword) {
        validate(accountNumber);
        findAccount(accountNumber).withdraw(amount, correctPassword);
    }

    public void transfer(int amount, String senderAccountNumber, String receiverAccountNumber, String senderPassword) {
        validate(senderAccountNumber, receiverAccountNumber);
        validate(senderAccountNumber);
        validate(receiverAccountNumber);
        withdraw(amount,senderAccountNumber,senderPassword);
        deposit(amount,receiverAccountNumber);
    }

    private void validate(String senderAccountNumber, String receiverAccountNumber) {
        if(senderAccountNumber.equals(receiverAccountNumber) ) throw new IllegalArgumentException("Same account number");
    }

    private void validate(String  accountNumber) {
        if(!nuban.isValid(accountNumber)) throw new IllegalArgumentException("Invalid account number");
        if(findAccount(accountNumber) == null) throw new IllegalArgumentException("Account number not found");
    }

    public String checkAccountName(String accountNumber) {
        validate(accountNumber);
        return findAccount(accountNumber).getAccountName();
    }
}

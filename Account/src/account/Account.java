package account;

public class Account {
    private int balance;
    private String password;
    private String accountName;
    private String accountNumber;

    public String getAccountNumber() { return accountNumber; }

    public String getAccountName() { return accountName; }

    public void set(String accountNumber) { this.accountNumber = accountNumber;}

    public Account(String accountName,String password) {
        this.balance = 0;
        this.password = password;
        this.accountName = accountName;
    }

    public int checkBalance(String password) {
        validate(password);
        return balance;
    }

    public void deposit(int amount) {
        validate(amount);
        balance += amount;
    }

    public void withdraw(int amount, String password) {
        validate(amount);
        validate(password);
        validateWithdrawal(amount);
        balance -= amount;
    }

    private void validateWithdrawal(int amount) {if(balance < amount) throw new IllegalArgumentException("Insufficient Balance");}

    public void changePassword(String newPassword) {this.password = newPassword;}

    private void validate(int amount){ if(amount <= 0) throw new IllegalArgumentException("Invalid amount"); }

    private void validate(String password){ if(!password.equals(this.password)) throw new IllegalArgumentException("Wrong password");}

}

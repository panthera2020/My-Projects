package account;

public class Account {
    private double balance = 0.0;
    private String password;

    public Account(String password) {this.password = password;}

    public double checkBalance(String password) {
        if (password.equals(this.password)) { return balance;}
        else{throw new IllegalArgumentException("Wrong password");}
    }

    public void deposit(double amount, String password) {if(amount > 0 && password.equals(this.password)) balance += amount;}

    public void withdraw(double amount, String password) {if(balance >= amount && password.equals(this.password)) balance -= amount;}

    public void changePassword(String newPassword) {this.password = newPassword;}
}

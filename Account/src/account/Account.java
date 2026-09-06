package account;

public class Account {
    private double balance = 0.0;

    public double checkBalance() {return balance;}

    public void deposit(double amount) {if(amount > 0) balance += amount;}

    public void withdraw(double amount) {if(balance >= amount) balance -= amount;}
}

package account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {
    private Bank bank;
    private final String correctPassword = "1234";
    private String name = "Seun";
    private final int accountNumber = 1;

    @BeforeEach
    public void setUp(){
        bank = new Bank();
        bank.createAccount(name,correctPassword);
    }

    @Test
    public void testThatBankCanCreateAccount(){
        assertEquals(1,bank.getNumberOfCustomer());
    }

    @Test
    public void testThatNewAccountHasAccountNumber(){
        assertEquals(0,bank.checkBalance(accountNumber,correctPassword));
    }

    @Test
    public void testThatNewAccountCanDeposit(){
        bank.deposit(5000,accountNumber, correctPassword);
        assertEquals(5000,bank.checkBalance(accountNumber,correctPassword));
    }

    @Test
    public void testThatWhenIDeposit5kAndIWithdraw3kFromAccount_BalanceIs2k(){
        bank.deposit(5000,accountNumber, correctPassword);
        bank.withdraw(3000,accountNumber, correctPassword);
        assertEquals(2000,bank.checkBalance(accountNumber,correctPassword));
    }
}

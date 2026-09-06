package account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void createAccount() {
        account = new Account();
    }

    @Test
    public void testThatWhenICheckBalance_OfNewAccount_BalanceIsZero() {
        assertEquals(0,account.checkBalance());
    }

    @Test
    public void testThatWhenIDeposit5k_BalanceIs5k() {
        assertEquals(0,account.checkBalance());
        account.deposit(5000.0);
        assertEquals(5000,account.checkBalance());
    }
    @Test
    public void testThatWhenIDeposit5kTwice_BalanceIs10k() {
        assertEquals(0,account.checkBalance());
        account.deposit(5000);
        assertEquals(5000,account.checkBalance());
        account.deposit(5000);
        assertEquals(10000,account.checkBalance());
    }

    @Test
    public void testThatWhenIDepositNegative1k_BalanceIsZero() {
        assertEquals(0,account.checkBalance());
        account.deposit(-5000);
        assertEquals(0,account.checkBalance());
    }
    @Test
    public void testThatWhenITryToWithdrawFromNewAccount_BalanceIsZero() {
        assertEquals(0,account.checkBalance());
        account.withdraw(5000.0);
        assertEquals(0,account.checkBalance());
    }

    @Test
    public void testThatWhenIDeposit5k_AndWithdraw2k_BalanceIs3k() {
        assertEquals(0,account.checkBalance());
        account.deposit(5000);
        assertEquals(5000,account.checkBalance());
        account.withdraw(2000);
        assertEquals(3000,account.checkBalance());
    }

    @Test
    public void testThatWhenIDeposit5k_AndWithdraw7k_BalanceIs5k() {
        assertEquals(0,account.checkBalance());
        account.deposit(5000);
        assertEquals(5000,account.checkBalance());
        account.withdraw(7000);
        assertEquals(5000,account.checkBalance());
    }

}

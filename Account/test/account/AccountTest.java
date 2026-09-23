package account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void createAccount() {
        account = new Account("1234");
    }

    @Test
    public void testThatIcannotCheckBalanceWithoutCorrectPassword() {
        assertThrows(IllegalArgumentException.class, ()-> account.checkBalance("1245"));
    }

    @Test
    public void testThatWhenICheckBalance_OfNewAccount_BalanceIsZero() {
        assertEquals(0,account.checkBalance("1234"));
    }
    @Test
    public void testThatICannotDepositWithoutCorrectPassword() {
        assertEquals(0,account.checkBalance("1234"));
        account.deposit(5000,"1245");
        assertEquals(0,account.checkBalance("1234"));
    }

    @Test
    public void testThatWhenIDeposit5k_BalanceIs5k() {
        assertEquals(0,account.checkBalance("1234"));
        account.deposit(5000.0,"1234");
        assertEquals(5000,account.checkBalance("1234"));
    }
    @Test
    public void testThatWhenIDeposit5kTwice_BalanceIs10k() {
        assertEquals(0,account.checkBalance("1234"));
        account.deposit(5000, "1234");
        assertEquals(5000,account.checkBalance("1234"));
        account.deposit(5000,"1234");
        assertEquals(10000,account.checkBalance("1234"));
    }

    @Test
    public void testThatWhenIDepositNegative1k_BalanceIsZero() {
        assertEquals(0,account.checkBalance("1234"));
        account.deposit(-5000,"1234");
        assertEquals(0,account.checkBalance("1234"));
    }

    @Test
    public void testThatWhenIDepositICannotWithrawWithoutCorrectPassword() {
        account.deposit(5000,"1234");
        account.withdraw(2000, "1255");
        assertEquals(5000,account.checkBalance("1234"));
    }

    @Test
    public void testThatWhenITryToWithdrawFromNewAccount_BalanceIsZero() {
        assertEquals(0,account.checkBalance("1234"));
        account.withdraw(5000.0,"1234");
        assertEquals(0,account.checkBalance("1234"));
    }

    @Test
    public void testThatWhenIDeposit5k_AndWithdraw2k_BalanceIs3k() {
        account.deposit(5000,"1234");
        assertEquals(5000,account.checkBalance("1234"));
        account.withdraw(2000,"1234");
        assertEquals(3000,account.checkBalance("1234"));
    }

    @Test
    public void testThatWhenIDeposit5k_AndWithdraw7k_BalanceIs5k() {
        assertEquals(0,account.checkBalance("1234"));
        account.deposit(5000.0,"1234");
        assertEquals(5000,account.checkBalance("1234"));
        account.withdraw(7000.0,"1234");
        assertEquals(5000,account.checkBalance("1234"));
    }

    @Test
    public void testThatWhenIChangePassword_PasswordIsChanged() {
        assertEquals(0,account.checkBalance("1234"));
        account.changePassword("5555");
        assertEquals(0,account.checkBalance("5555"));
    }


}

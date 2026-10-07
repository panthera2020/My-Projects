package account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    private String correctPassword = "1234";
    private Account account;

    @BeforeEach
    public void createAccount() {
        account = new Account("Bola",correctPassword);
    }

    @Test
    public void testThatICannotCheckBalanceWithoutCorrectPassword() {
        assertThrows(IllegalArgumentException.class, ()-> account.checkBalance("1245"));
    }

    @Test
    public void testThatWhenICheckBalance_OfNewAccount_BalanceIsZero() {
        assertEquals(0,account.checkBalance(correctPassword));
    }

    @Test
    public void testThatWhenIDeposit5k_BalanceIs5k() {
        assertEquals(0,account.checkBalance(correctPassword));
        account.deposit(5000);
        assertEquals(5000,account.checkBalance(correctPassword));
    }
    @Test
    public void testThatWhenIDeposit5kTwice_BalanceIs10k() {
        assertEquals(0,account.checkBalance(correctPassword));
        account.deposit(5000);
        assertEquals(5000,account.checkBalance(correctPassword));
        account.deposit(5000);
        assertEquals(10000,account.checkBalance(correctPassword));
    }

    @Test
    public void testThatWhenIDepositNegative1k_ErrorIsThrown() {
        assertEquals(0,account.checkBalance(correctPassword));
        assertThrows(IllegalArgumentException.class, ()-> account.deposit(-5000));
    }

    @Test
    public void testThatWhenITryToWithdrawFromNewAccount_ErrorIsThrown() {
        assertEquals(0,account.checkBalance(correctPassword));
        assertThrows(IllegalArgumentException.class, ()-> account.withdraw(5000,correctPassword));
    }

    @Test
    public void testThatWhenIDeposit5k_AndWithdraw2k_BalanceIs3k() {
        account.deposit(5000);
        assertEquals(5000,account.checkBalance(correctPassword));
        account.withdraw(2000,correctPassword);
        assertEquals(3000,account.checkBalance(correctPassword));
    }

    @Test
    public void testThatWhenIDeposit5k_AndWithdraw7k_ErrorIsThrown() {
        assertEquals(0,account.checkBalance(correctPassword));
        account.deposit(5000);
        assertEquals(5000,account.checkBalance(correctPassword));
        assertThrows(IllegalArgumentException.class, ()-> account.withdraw(7000,correctPassword));
    }

    @Test
    public void testThatWhenIChangePassword_PasswordIsChanged() {
        assertEquals(0,account.checkBalance(correctPassword));
        account.changePassword("5555");
        assertEquals(0,account.checkBalance("5555"));
    }

    @Test
    public void testThatWhenAccountIsCreatedICanGetAccountName(){
        assertEquals("Bola",account.getAccountName());
    }

    @Test
    public void testThatWhenAccountIsCreatedAndAccountNumberIsSetICanGetAccountNumber(){
        String accountNumber = "1";
        account.set(accountNumber);
        assertEquals(accountNumber,account.getAccountNumber());
    }

    @Test
    public void testThatICannotDepositZeroAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
    }

    @Test
    public void testThatICannotWithdrawZeroAmount() {
        account.deposit(5000);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0, correctPassword));
    }

    @Test
    public void testThatWhenIWithdrawWithWrongPassword_ErrorIsThrown() {
        account.deposit(5000);
        assertEquals(5000, account.checkBalance(correctPassword));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(1000, "wrongPassword"));
    }

    @Test
    public void testThatWhenIWithdrawExactlyTheFullBalance_BalanceBecomesZero() {
        account.deposit(5000);
        assertEquals(5000, account.checkBalance(correctPassword));
        account.withdraw(5000, correctPassword);
        assertEquals(0, account.checkBalance(correctPassword));
    }
}

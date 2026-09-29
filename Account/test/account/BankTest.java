package account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {
    private Bank bank;
    private final String correctPassword = "1234";
    private final String wrongPassword = "12345";
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
        bank.deposit(5000,accountNumber);
        assertEquals(5000,bank.checkBalance(accountNumber,correctPassword));
    }

    @Test
    public void testThatWhenIDeposit5kAndIWithdraw3kFromAccount_BalanceIs2k(){
        bank.deposit(5000,accountNumber);
        bank.withdraw(3000,accountNumber, correctPassword);
        assertEquals(2000,bank.checkBalance(accountNumber,correctPassword));
    }

    @Test
    public void testThatAccountCanTransferFromOneAccountToAnother(){
        bank.deposit(5000,accountNumber);
        String receiverName = "Bola";
        String receiverPassword = "4232";
        bank.createAccount(receiverName, receiverPassword);
        int senderAccountNumber = 1;
        int receiverAccountNumber = 2;
        String senderPassword = correctPassword;
        bank.transfer(5000, senderAccountNumber, receiverAccountNumber,senderPassword);
        assertEquals(0,bank.checkBalance(senderAccountNumber,senderPassword));
        assertEquals(5000,bank.checkBalance(receiverAccountNumber,receiverPassword));
    }

    @Test
    public void testThatAccountTransferToTheSameAccountNumberThrowsError(){
        int senderAccountNumber = accountNumber;
        int receiverAccountNumber = accountNumber;
        assertThrows(IllegalArgumentException.class,()-> bank.transfer(5000, senderAccountNumber, receiverAccountNumber,correctPassword));
    }

    @Test
    public void testThatIfAccountNumberIsNotInBankAndIDeposit_ThrowsError(){
        assertThrows(IllegalArgumentException.class,()-> bank.deposit(5000,4));
    }

    @Test
    public void testThatIfAccountNumberIsNotInBankAndIWithdraw_ThrowsError(){
        assertThrows(IllegalArgumentException.class,()-> bank.withdraw(5000,5,correctPassword));
    }

    @Test
    public void testThatWhenOneAccountAreAddedICanGetNumberOfCustomer(){
        assertEquals(1,bank.getNumberOfCustomer());
    }

    @Test
    public void testThatWhenITransferFromAccountNumberNotInBankErrorIsThrown(){
        int senderAccountNumber = 5;
        int receiverAccountNumber = accountNumber;
        assertThrows(IllegalArgumentException.class,()-> bank.transfer(5000, senderAccountNumber, receiverAccountNumber,correctPassword));
    }

    @Test
    public void testThatWhenITransferToAccountNumberNotInBankErrorIsThrown(){
        int senderAccountNumber = accountNumber;
        int receiverAccountNumber = 3;
        assertThrows(IllegalArgumentException.class,()-> bank.transfer(5000, senderAccountNumber, receiverAccountNumber,correctPassword));
    }

    @Test
    public void testThatWhenICheckBalanceFromAccountNumberNotInBankErrorIsThrown(){
        assertThrows(IllegalArgumentException.class,()-> bank.checkBalance(5,correctPassword));
    }

    @Test
    public void testThatCheckBalanceWithWrongPassword_ThrowsError() {
        bank.deposit(5000, accountNumber);
        assertThrows(IllegalArgumentException.class, () -> bank.checkBalance(accountNumber, wrongPassword));
    }

    @Test
    public void testThatWithdrawWithWrongPassword_ThrowsError() {
        bank.deposit(5000, accountNumber);
        assertThrows(IllegalArgumentException.class, () -> bank.withdraw(1000, accountNumber, wrongPassword));
    }

    @Test
    public void testThatTransferWithWrongSenderPassword_ThrowsError() {
        bank.deposit(5000, accountNumber);
        String receiverName = "Bola";
        String receiverPassword = "4232";
        bank.createAccount(receiverName, receiverPassword);
        assertThrows(IllegalArgumentException.class, () -> bank.transfer(5000, accountNumber, 2, wrongPassword));
    }

    @Test
    public void testThatTransferWithInsufficientBalance_ThrowsError() {
        bank.deposit(3000, accountNumber);
        String receiverName = "Bola";
        String receiverPassword = "4232";
        bank.createAccount(receiverName, receiverPassword);
        assertThrows(IllegalArgumentException.class, () -> bank.transfer(5000, accountNumber, 2, correctPassword));
    }

    @Test
    public void testThatDepositNegativeAmountThroughBank_ThrowsError() {
        assertThrows(IllegalArgumentException.class, () -> bank.deposit(-1000, accountNumber));
    }

    @Test
    public void testThatWithdrawNegativeAmountThroughBank_ThrowsError() {
        bank.deposit(5000, accountNumber);
        assertThrows(IllegalArgumentException.class, () -> bank.withdraw(-1000, accountNumber, correctPassword));
    }

    @Test
    public void testThatTransferWithNegativeAmount_ThrowsError() {
        bank.deposit(5000, accountNumber);
        bank.createAccount("Bola", "4232");
        assertThrows(IllegalArgumentException.class, () -> bank.transfer(-1000, accountNumber, 2, correctPassword));
    }
}

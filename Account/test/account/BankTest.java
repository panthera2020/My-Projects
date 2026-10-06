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
    private int accountNumber;
    private final int amount = 5000;

    @BeforeEach
    public void setUp(){
        bank = new Bank("058");
        accountNumber = bank.createAccount(name,correctPassword);
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
        bank.deposit(amount,accountNumber);
        assertEquals(amount,bank.checkBalance(accountNumber,correctPassword));
    }

    @Test
    public void testThatWhenIDeposit5kAndIWithdraw3kFromAccount_BalanceIs2k(){
        bank.deposit(amount,accountNumber);
        bank.withdraw(3000,accountNumber, correctPassword);
        assertEquals(2000,bank.checkBalance(accountNumber,correctPassword));
    }

    @Test
    public void testThatAccountCanTransferFromOneAccountToAnother(){
        bank.deposit(amount,accountNumber);
        String receiverName = "Bola";
        String receiverPassword = "4232";
        bank.createAccount(receiverName, receiverPassword);
        int senderAccountNumber = 1;
        int receiverAccountNumber = 2;
        String senderPassword = correctPassword;
        bank.transfer(amount, senderAccountNumber, receiverAccountNumber,senderPassword);
        assertEquals(0,bank.checkBalance(senderAccountNumber,senderPassword));
        assertEquals(amount,bank.checkBalance(receiverAccountNumber,receiverPassword));
    }

    @Test
    public void testThatAccountTransferToTheSameAccountNumberThrowsError(){
        int senderAccountNumber = accountNumber;
        int receiverAccountNumber = accountNumber;
        assertThrows(IllegalArgumentException.class,()-> bank.transfer(amount, senderAccountNumber, receiverAccountNumber,correctPassword));
    }

    @Test
    public void testThatIfAccountNumberIsNotInBankAndIDeposit_ThrowsError(){
        assertThrows(IllegalArgumentException.class,()-> bank.deposit(amount,4));
    }

    @Test
    public void testThatIfAccountNumberIsNotInBankAndIWithdraw_ThrowsError(){
        assertThrows(IllegalArgumentException.class,()-> bank.withdraw(amount,5,correctPassword));
    }

    @Test
    public void testThatWhenOneAccountAreAddedICanGetNumberOfCustomer(){
        assertEquals(1,bank.getNumberOfCustomer());
    }

    @Test
    public void testThatWhenITransferFromAccountNumberNotInBankErrorIsThrown(){
        int senderAccountNumber = 5;
        int receiverAccountNumber = accountNumber;
        assertThrows(IllegalArgumentException.class,()-> bank.transfer(amount, senderAccountNumber, receiverAccountNumber,correctPassword));
    }

    @Test
    public void testThatWhenITransferToAccountNumberNotInBankErrorIsThrown(){
        int senderAccountNumber = accountNumber;
        int receiverAccountNumber = 3;
        assertThrows(IllegalArgumentException.class,()-> bank.transfer(amount, senderAccountNumber, receiverAccountNumber,correctPassword));
    }

    @Test
    public void testThatWhenICheckBalanceFromAccountNumberNotInBankErrorIsThrown(){
        assertThrows(IllegalArgumentException.class,()-> bank.checkBalance(5,correctPassword));
    }

    @Test
    public void testThatCheckBalanceWithWrongPassword_ThrowsError() {
        bank.deposit(amount, accountNumber);
        assertThrows(IllegalArgumentException.class, () -> bank.checkBalance(accountNumber, wrongPassword));
    }

    @Test
    public void testThatWithdrawWithWrongPassword_ThrowsError() {
        bank.deposit(amount, accountNumber);
        assertThrows(IllegalArgumentException.class, () -> bank.withdraw(1000, accountNumber, wrongPassword));
    }

    @Test
    public void testThatTransferWithWrongSenderPassword_ThrowsError() {
        bank.deposit(amount, accountNumber);
        String receiverName = "Bola";
        String receiverPassword = "4232";
        bank.createAccount(receiverName, receiverPassword);
        assertThrows(IllegalArgumentException.class, () -> bank.transfer(amount, accountNumber, 2, wrongPassword));
    }

    @Test
    public void testThatTransferWithInsufficientBalance_ThrowsError() {
        bank.deposit(3000, accountNumber);
        String receiverName = "Bola";
        String receiverPassword = "4232";
        bank.createAccount(receiverName, receiverPassword);
        assertThrows(IllegalArgumentException.class, () -> bank.transfer(amount, accountNumber, 2, correctPassword));
    }

    @Test
    public void testThatDepositNegativeAmountThroughBank_ThrowsError() {
        assertThrows(IllegalArgumentException.class, () -> bank.deposit(-1000, accountNumber));
    }

    @Test
    public void testThatWithdrawNegativeAmountThroughBank_ThrowsError() {
        bank.deposit(amount, accountNumber);
        assertThrows(IllegalArgumentException.class, () -> bank.withdraw(-1000, accountNumber, correctPassword));
    }

    @Test
    public void testThatTransferWithNegativeAmount_ThrowsError() {
        bank.deposit(amount, accountNumber);
        bank.createAccount("Bola", "4232");
        assertThrows(IllegalArgumentException.class, () -> bank.transfer(-1000, accountNumber, 2, correctPassword));
    }

    @Test
    public void testThatWhenITransferFromOneAccountItDecreaseByAmount_RecipientAccountIncreaseByAmount(){
        bank.deposit(amount, accountNumber);
        bank.createAccount("Bola", "4232");
        assertEquals(amount,bank.checkBalance(accountNumber,correctPassword));
        bank.transfer(amount, accountNumber, 2, correctPassword);
        assertEquals(0,bank.checkBalance(accountNumber,correctPassword));
        assertEquals(amount,bank.checkBalance(2,"4232"));
    }

    @Test
    public void testThatWhenIHaveAccountNumberICanReturnNameOfCustomer(){
        assertEquals("Seun",bank.checkAccountName(accountNumber));
    }
}

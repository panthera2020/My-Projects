import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NubanTest {

    @Test
    public void testThatWhenIGetANumberItReturnsTrueIfItsAValidAccountNumber(){
        Nuban nuban = new Nuban();
        String accountNumberOne = "0110000014579";
        String accountNumberTwo = "0110000000220";
        assertTrue(nuban.isValid(accountNumberTwo));
        assertTrue(nuban.isValid(accountNumberOne));
    }

    @Test
    public void testThatWhenICreateAccountNumberAccountNumberIsValid(){
        Nuban nuban = new Nuban();
        String bankCode = "011";
        String accountNumber = nuban.create(bankCode);
        assertTrue(nuban.isValid(accountNumber));
    }
}

package account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BanksTest {
    private final Banks cbn = Banks.getNibs();
    private final Nuban nuban = new Nuban();

    @Test
    public void testThatBanksIsASingleton(){
        assertSame(Banks.getNibs(), Banks.getNibs());
    }

    @Test
    public void testThatWhenBanksIsCreatedAllBanksAreCreated(){
        assertEquals(BankCode.values().length, cbn.getRegisteredBanks().size());
    }

    @Test
    public void testThatEveryBankCodeHasExactlyOneBank(){
        for (BankCode bankCode : BankCode.values()) {
            int count = 0;
            for (Bank bank : cbn.getRegisteredBanks()) {
                if (bank.getBankCode() == bankCode) count++;
            }
            assertEquals(1, count);
        }
    }

    @Test
    public void testThatBanksFindsTheRightBankForEveryBankCode(){
        for (BankCode bankCode : BankCode.values()) {
            String accountNumber = nuban.create(bankCode.getBankCode());
            assertEquals(bankCode, cbn.findBankOf(accountNumber).getBankCode());
        }
    }

    @Test
    public void testThatBanksFindsTheBankOfAnAccountThatWasCreated(){
        Bank firstBank = cbn.findBankOf(nuban.create(BankCode.FIRST_BANK.getBankCode()));
        String accountNumber = firstBank.createAccount("Seun", "1234");
        assertSame(firstBank, cbn.findBankOf(accountNumber));
    }

    @Test
    public void testThatFindingABankLooksOnlyAtTheFirstThreeDigits(){
        assertEquals(BankCode.GUARANTY_TRUST_BANK, cbn.findBankOf("0580000000000").getBankCode());
    }

    @Test
    public void testThatFindingBankWithUnknownBankCode_ErrorIsThrown(){
        assertThrows(IllegalArgumentException.class, () -> cbn.findBankOf("9990000000000"));
    }

    @Test
    public void testThatFindingBankWithTooShortAccountNumber_ErrorIsThrown(){
        assertThrows(IllegalArgumentException.class, () -> cbn.findBankOf("1234"));
    }

    @Test
    public void testThatFindingBankWithTooLongAccountNumber_ErrorIsThrown(){
        assertThrows(IllegalArgumentException.class, () -> cbn.findBankOf("01100000145790"));
    }

    @Test
    public void testThatFindingBankWithEmptyAccountNumber_ErrorIsThrown(){
        assertThrows(IllegalArgumentException.class, () -> cbn.findBankOf(""));
    }
}
package account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InterBankTest {

    private final Banks banks = Banks.getNibs();
    private final String seunPassword = "1234";
    private final String bolaPassword = "4321";
    private Bank firstBank;
    private Bank gtbBank;
    private String seunNumber;
    private String bolaNumber;

    @BeforeEach
    public void setUp() {
        firstBank = banks.findBank(BankCode.FIRST_BANK);
        gtbBank = banks.findBank(BankCode.GUARANTY_TRUST_BANK);
        seunNumber = firstBank.createAccount("Seun", seunPassword);
        bolaNumber = gtbBank.createAccount("Bola", bolaPassword);
        firstBank.deposit(10000, seunNumber);
    }

    @Test
    public void testThatInterbankTransferMovesMoneyFromSenderToReceiver() {
        firstBank.transfer(2500, seunNumber, bolaNumber, seunPassword);
        assertEquals(7500, firstBank.checkBalance(seunNumber, seunPassword));
        assertEquals(2500, gtbBank.checkBalance(bolaNumber, bolaPassword));
    }

    @Test
    public void testThatInterbankTransferWorksInTheOtherDirection() {
        gtbBank.deposit(4000, bolaNumber);
        gtbBank.transfer(1500, bolaNumber, seunNumber, bolaPassword);
        assertEquals(2500, gtbBank.checkBalance(bolaNumber, bolaPassword));
        assertEquals(11500, firstBank.checkBalance(seunNumber, seunPassword));
    }

    @Test
    public void testThatInterbankTransferToNonExistentAccount_ThrowsAndSenderIsUnchanged() {
        String ghost = new Nuban().create(BankCode.GUARANTY_TRUST_BANK.getBankCode());
        assertThrows(IllegalArgumentException.class, ()-> firstBank.transfer(2500, seunNumber, ghost, seunPassword));
        assertEquals(10000, firstBank.checkBalance(seunNumber, seunPassword));
    }

    @Test
    public void testThatInterbankTransferWithWrongPassword_ThrowsAndNothingMoves() {
        assertThrows(IllegalArgumentException.class, ()-> firstBank.transfer(2500, seunNumber, bolaNumber, "wrong"));
        assertEquals(10000, firstBank.checkBalance(seunNumber, seunPassword));
        assertEquals(0, gtbBank.checkBalance(bolaNumber, bolaPassword));
    }

    @Test
    public void testThatInterbankTransferWithInsufficientBalance_ThrowsAndNothingMoves() {
        assertThrows(IllegalArgumentException.class, ()-> firstBank.transfer(10001, seunNumber, bolaNumber, seunPassword));
        assertEquals(10000, firstBank.checkBalance(seunNumber, seunPassword));
        assertEquals(0, gtbBank.checkBalance(bolaNumber, bolaPassword));
    }

    @Test
    public void testThatInterbankTransferOfNegativeAmount_ThrowsAndNothingMoves() {
        assertThrows(IllegalArgumentException.class, ()-> firstBank.transfer(-500, seunNumber, bolaNumber, seunPassword));
        assertEquals(10000, firstBank.checkBalance(seunNumber, seunPassword));
        assertEquals(0, gtbBank.checkBalance(bolaNumber, bolaPassword));
    }

    @Test
    public void testThatTransferFromAccountThatBelongsToAnotherBank_Throws() {
        assertThrows(IllegalArgumentException.class, ()-> gtbBank.transfer(2500, seunNumber, bolaNumber, seunPassword));
        assertEquals(10000, firstBank.checkBalance(seunNumber, seunPassword));
    }
}

package account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BanksTest {
    private String password = "1234";
    private Banks cbn;
    private Bank firstBank ;
    private Bank accessBank;
    private Bank fidelityBank;

    @BeforeEach
    public void setUp() {
        cbn = new Banks();
        firstBank = new Bank(BankCode.FIRST_BANK);
        accessBank = new Bank(BankCode.ACCESS_BANK);
        fidelityBank = new Bank(BankCode.FIDELITY_BANK);
    }

    @Test
    public void testThatWhenBanksCanOneBank(){
        Bank gtbBank = new Bank(BankCode.GUARANTY_TRUST_BANK);
        cbn.add(gtbBank);
        assertEquals(1,cbn.getNumberOfRegisteredBanks().size());
    }

    @Test
    public void testThatWhenBanksCanMultipleBanks(){
        cbn.add(firstBank);
        cbn.add(accessBank);
        cbn.add(fidelityBank);
        assertEquals(3,cbn.getNumberOfRegisteredBanks().size());
    }

    @Test
    public void testThatWhenBanksFindBank(){
        cbn.add(firstBank);
        String firstBankAccountNumber = firstBank.createAccount("Seun", password);
        Bank foundBank = cbn.findBankOf(firstBankAccountNumber);
        assertEquals(foundBank, firstBank);
    }

    @Test
    public void testThatWhenBanksFindAccountWithInvalidAccountNumber_ErrorIsThrown(){
        cbn.add(firstBank);
        firstBank.createAccount("Seun", password);
        assertThrows(IllegalArgumentException.class,()-> cbn.findBankOf("213456567432"));
    }

    @Test
    public void testThatWhenBankFindsAccountAndAccountNumberHasNotBeenCreated_ErrorIsThrown(){
        cbn.add(firstBank);
        assertThrows(IllegalArgumentException.class,()-> cbn.findBankOf("1234"));
    }

    @Test
    public void testThatBankCanTransferFromOne5kFromOneBankToAnotherBank(){
        cbn.add(firstBank);
        String firstBankAccountNumber = firstBank.createAccount("Seun", password);
        firstBank.deposit(10000, firstBankAccountNumber);
        cbn.add(fidelityBank);
        String fidelityBankAccountNumber = fidelityBank.createAccount("Honour", "4321");
        cbn.transfer(5000, firstBankAccountNumber, fidelityBankAccountNumber, password);
        assertEquals(5000, firstBank.checkBalance(firstBankAccountNumber, password));
        assertEquals(5000, fidelityBank.checkBalance(fidelityBankAccountNumber, "4321"));
    }


}

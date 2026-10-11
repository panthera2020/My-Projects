package account;

import java.util.ArrayList;
import java.util.List;

public class Banks {
    private static final Banks NIBS = new Banks();
    private List<Bank> nibs = new ArrayList<Bank>();

    private Banks() {
        for (BankCode bankCode : BankCode.values()) { nibs.add(new Bank(bankCode)); }
    }

    public static Banks getNibs() { return NIBS; }

    public List<Bank> getRegisteredBanks() { return nibs;}

    public Bank findBankOf(String accountNumber) {
        validateLengthOf(accountNumber);
        validate(accountNumber);
        for (Bank bank : nibs) {
            BankCode eachBank = bank.getBankCode();
            if(eachBank.getBankCode().equals(getFirstThreeDigits(accountNumber))){return bank;}
        }
        throw new IllegalArgumentException("Bank not found");
    }

    public Bank findBank(BankCode code) {
        for (Bank bank : nibs) {
            if (bank.getBankCode() == code) return bank;
        }
        throw new IllegalArgumentException("Bank not found");
    }

    private String getFirstThreeDigits(String accountNumber) { return accountNumber.substring(0,3);}

    private void validate(String accountNumber) {
        if(!isValid(accountNumber)) throw new IllegalArgumentException("Account does not exist");
    }
    private void validateLengthOf(String accountNumber) {
        if(accountNumber.length() != 13) throw new IllegalArgumentException("Account number is too short");
    }

    private boolean isValid(String accountNumber) {
        for (Bank bank : nibs) {
            BankCode eachBank = bank.getBankCode();
            if(eachBank.getBankCode().equals(getFirstThreeDigits(accountNumber))){return true;}
        }
        return false;
    }
}
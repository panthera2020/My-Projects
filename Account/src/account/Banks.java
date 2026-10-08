package account;

import java.util.ArrayList;
import java.util.List;

public class Banks {
    private List<Bank> cbn = new ArrayList<Bank>();

    public void add(Bank bank) { cbn.add(bank);}

    public List<Bank> getRegisteredBanks() { return cbn;}

    public Bank findBankOf(String accountNumber) {
        validate(accountNumber);
        for (Bank bank : cbn) {
            BankCode eachBank = bank.getBankCode();
            if(eachBank.getBankCode().equals(getFirstThreeDigits(accountNumber))){return bank;}
        }
        return null;
    }

    private String getFirstThreeDigits(String accountNumber) { return accountNumber.substring(0,3);}

    public void transfer(int amount, String senderAccountNumber, String receiverAccountNumber, String senderPassword) {
        Bank senderBank = findBankOf(senderAccountNumber);
        Bank receiverBank = findBankOf(receiverAccountNumber);
        senderBank.withdraw(amount,senderAccountNumber,senderPassword);
        receiverBank.deposit(amount,receiverAccountNumber);
    }

    private void validate(String accountNumber) {
        if(!isValid(accountNumber)) throw new IllegalArgumentException("Account does not exist");
    }

    private boolean isValid(String accountNumber) {
        for (Bank bank : cbn) {
            BankCode eachBank = bank.getBankCode();
            if(eachBank.getBankCode().equals(getFirstThreeDigits(accountNumber))){return true;}
        }
        return false;
    }
}

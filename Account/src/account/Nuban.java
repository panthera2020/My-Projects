package account;

import java.util.concurrent.ThreadLocalRandom;

public class Nuban {
    private static final int[] WEIGHTS = {3, 7, 3, 3, 7, 3, 3, 7, 3, 3, 7, 3};

    public boolean isValid(String accountNumber) {
        validateLengthOf(accountNumber);
        int lastDigit = Character.getNumericValue(accountNumber.charAt(accountNumber.length() - 1));
        int sum = toValidateGetSumOfDigitsOf(accountNumber);
        return isEquals(sum, lastDigit) && isFirstThreeDigitValidIn(accountNumber);
    }

    public String create(String bankCode) {
        int digits = ThreadLocalRandom.current().nextInt(100000000, 1000000000);
        String bankCodeAndDigit = bankCode + digits;
        return bankCodeAndDigit + getLastDigit(bankCodeAndDigit);
    }

    private boolean isFirstThreeDigitValidIn(String accountNumber) {
        String firstThreeDigitAccountNumber = accountNumber.substring(0, 3);
        for(BankCode bankCode : BankCode.values()){
            if(firstThreeDigitAccountNumber.equals(bankCode.getBankCode())){return true;}
        }
        return false;
    }

    private boolean isEquals(int sum, int lastDigit) {
        int checkDigit = 10 - (sum % 10);
        if(checkDigit == 10) checkDigit = 0;
        return checkDigit == lastDigit;
    }

    private void validateLengthOf(String accountNumber) {
        if(accountNumber.length() != 13){throw new IllegalArgumentException("Invalid account number");}
    }

    private int getLastDigit(String accountNumber) {
        int checkDigit = 10 - (toCreateGetSumOfDigitsOf(accountNumber) % 10);
        if(checkDigit == 10) checkDigit = 0;
        return checkDigit;
    }

    private int toCreateGetSumOfDigitsOf(String accountNumber) {
        int sum = 0;
        for(int index = 0; index < accountNumber.length(); index++) {sum += (WEIGHTS[index] * Character.getNumericValue(accountNumber.charAt(index)));}
        return sum;
    }

    private int toValidateGetSumOfDigitsOf(String accountNumber) {
        int sum = 0;
        for(int index = 0; index < WEIGHTS.length; index++) {sum += (WEIGHTS[index] * Character.getNumericValue(accountNumber.charAt(index)));}
        return sum;
    }
}

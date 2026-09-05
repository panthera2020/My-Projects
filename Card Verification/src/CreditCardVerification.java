public class CreditCardVerification {

    public boolean isLenghtValid(long cardNumber) {
        int counter = 0;
        boolean isCreditCardValid = true;

        while(cardNumber != 0){
            long numbersInIntegers = cardNumber % 10;
            counter++;
            cardNumber /= 10;
        }

        if(counter >= 13 && counter <= 16){
            isCreditCardValid = true;
        }else{
            isCreditCardValid = false;
        }

        return isCreditCardValid;
    }

    public boolean isFirstDigitValid(long cardNumber) {
        String cardNumberString = cardNumber + "";
        char firstDigit = cardNumberString.charAt(0);
        char secondDigit = cardNumberString.charAt(1);

        boolean isFirstDigit = false;

        if(firstDigit == '4' || firstDigit == '5' || firstDigit == '6' || (firstDigit == '3' && secondDigit == '7')){
            isFirstDigit = true;
        }
        return isFirstDigit;
    }

    public String cardType(long cardNumber) {
        String cardNumberString = cardNumber + "";
        char firstDigit = cardNumberString.charAt(0);
        String cardType = "";
        if(firstDigit == '4'){
            cardType = "Visa";
        }
        return cardType;
    }
}

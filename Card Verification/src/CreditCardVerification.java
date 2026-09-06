public class CreditCardVerification {

    public boolean isLenghtValid(long cardNumber) {
        boolean isCreditCardValid = false;
        int counter = getCardLength(cardNumber);
        if(counter >= 13 && counter <= 16){
            isCreditCardValid = true;
        }
        return isCreditCardValid;
    }

    public int getCardLength(long cardNumber) {
        int counter = 0;
        while(cardNumber != 0){
            long numbersInIntegers = cardNumber % 10;
            counter++;
            cardNumber /= 10;
        }
        return counter;
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
        char secondDigit = cardNumberString.charAt(1);

        String cardType = "";
        if(firstDigit == '4'){
            cardType = "Visa";
        }if(firstDigit == '5'){
            cardType = "MasterCard";
        }if(firstDigit == '6'){
            cardType = "Discover Card";
        }if(firstDigit == '3' && secondDigit == '7'){
            cardType = "American Express Card";
        }
        return cardType;
    }

    public int [] getArrayOf(long numbers) {
        String numberToString = numbers + "";
        String [] stringNumbersToArray = numberToString.split("");
        int [] arrayOfNumbers = new int[stringNumbersToArray.length];
        for(int index = 0; index < stringNumbersToArray.length; index++){
            arrayOfNumbers[index] = Integer.parseInt(stringNumbersToArray[index]);
        }
        return arrayOfNumbers;
    }

    public int [] doubleSecondElementsRightToLeft(long numbers) {
        int [] arrayOfNumbers = getArrayOf(numbers);
        for(int index = arrayOfNumbers.length - 2; index >= 0; index-=2){
            arrayOfNumbers[index] = arrayOfNumbers[index] * 2;
        }
        return arrayOfNumbers;
    }

    public int[] doubleSecondElementsRightToLeftNoDoubleDigitElement(long numbers) {
        int [] arrayOfNumbers = doubleSecondElementsRightToLeft(numbers);
        int sum = 0;
        for(int index = arrayOfNumbers.length - 2; index >= 0; index-=2){
            if(arrayOfNumbers[index] > 9){
                int doubleDigitIndex = arrayOfNumbers[index];
                while(doubleDigitIndex != 0){
                    int digit =  doubleDigitIndex % 10;
                    sum  += digit;
                    doubleDigitIndex = doubleDigitIndex / 10;
                }
                arrayOfNumbers[index] = sum;
            }
        }
        return arrayOfNumbers;
    }

    public int sumOfSecondDigitsRightToLeft(long numbers) {
        int []  arrayOfNumbers = doubleSecondElementsRightToLeftNoDoubleDigitElement(numbers);
        int sum = 0;
        for(int index = arrayOfNumbers.length - 2; index >= 0; index-=2){
            sum += arrayOfNumbers[index];
        }
        return sum;
    }

    public int sumOfOddPlacedDigitsRightToLeft(long numbers) {
        int []  arrayOfNumbers = doubleSecondElementsRightToLeftNoDoubleDigitElement(numbers);
        int sum = 0;
        for(int index = arrayOfNumbers.length - 1; index >= 0; index-=2){
            sum += arrayOfNumbers[index];
        }
        return sum;
    }


    public int sumOfOddPlacedSecondDigitsRightToLeft(long numbers) {
        return sumOfOddPlacedDigitsRightToLeft(numbers) + sumOfSecondDigitsRightToLeft(numbers);
    }

    public boolean isCardValid(long number) {
        return sumOfOddPlacedSecondDigitsRightToLeft(number) % 2 == 0;
    }
}

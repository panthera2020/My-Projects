import java.util.Arrays;

public class Lcm {

    public int getGreatestCommonDivisor(int firstNumber, int secondNumber) {
        int greatestCommonDivisor = 1;
        if(firstNumber < secondNumber){
            while( greatestCommonDivisor != 0){
                greatestCommonDivisor = secondNumber % firstNumber;
                secondNumber = firstNumber;
                firstNumber = greatestCommonDivisor;
            }
            return secondNumber;
        }else{
            while( greatestCommonDivisor != 0){
                greatestCommonDivisor = firstNumber % secondNumber;
                firstNumber = secondNumber;
                secondNumber = greatestCommonDivisor;
            }
            return firstNumber;
        }
    }

    public int getProductOfGreatestCommonDivisor(int[] arrayOfNumbers) {
        Arrays.sort(arrayOfNumbers);
        int lcm = arrayOfNumbers[0];
        for(int index = 0; index < arrayOfNumbers.length - 1; index++){
            int counter = index + 1;
            int gcd = getGreatestCommonDivisor(lcm, arrayOfNumbers[counter]);
            lcm = (lcm * arrayOfNumbers[counter]) / gcd;
        }
        return lcm;
    }
}

// INCORRECT LCM CALCULATION


import java.util.ArrayList;

public class LowestCommonMultiple {
    public int [] getLowestCommonMultiples(int number) {
        ArrayList<Integer> multiples = new ArrayList<>();
        int count = 2;
        while(number != 1){
            if(number % count == 0){
                number /= count;
                multiples.add(count);
            }else {
                count++;
            }

        }
        int [] result = new int[multiples.size()];
        for(int index = 0; index < multiples.size(); index++){
            result[index] = multiples.get(index);
        }
        return result;
    }

    public int [] getLongestArray(int[] firstArrayOfNumbers, int[] secondArrayOfNumbers) {
        int [] longestArray=  new int[1];
        if(firstArrayOfNumbers.length > secondArrayOfNumbers.length){
            longestArray = firstArrayOfNumbers;
        }else if(secondArrayOfNumbers.length > firstArrayOfNumbers.length){
            longestArray = secondArrayOfNumbers;
        }else{
            longestArray = firstArrayOfNumbers;
        }
        return longestArray;
    }

    public int [] addElementsNotIn(int[] firstArrayOfNumbers, int[] secondArrayOfNumbers) {
        ArrayList<Integer> arrayOfNumbers = new ArrayList<>();
        int [] longestArray = getLongestArray(firstArrayOfNumbers, secondArrayOfNumbers);
        for(int index = 0; index < longestArray.length; index++){
            arrayOfNumbers.add(longestArray[index]);
        }
        for(int index = 0; index < firstArrayOfNumbers.length; index++){
            if(!arrayOfNumbers.contains(firstArrayOfNumbers[index])){
                arrayOfNumbers.add(firstArrayOfNumbers[index]);
            }
        }
        for(int index = 0; index < secondArrayOfNumbers.length; index++){
            if(!arrayOfNumbers.contains(secondArrayOfNumbers[index])){
                arrayOfNumbers.add(secondArrayOfNumbers[index]);
            }
        }

        int [] result = new int[arrayOfNumbers.size()];
        for(int index = 0; index < arrayOfNumbers.size(); index++){
            result[index] = arrayOfNumbers.get(index);
        }

        return result;
    }

    public int getProductOfLowestCommonMultiples(int[] arrayOfNumbers) {
        ArrayList<int []> numbers = new ArrayList<>();
        int product = 1;

        for(int index = 0; index < arrayOfNumbers.length; index++){
            int [] lowestCommonMultiples = getLowestCommonMultiples(arrayOfNumbers[index]);
            numbers.add(lowestCommonMultiples);
        }
        int [] largest = new int[0];
        for(int [] eachArray : numbers){
            largest = getLongestArray(eachArray, largest);
        }
        for(int [] eachArray : numbers){
            largest = addElementsNotIn(largest, eachArray);
        }

        for(int index = 0; index < largest.length; index++){
            product *= largest[index];
        }

        return product;
    }
}

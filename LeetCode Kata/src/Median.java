import java.util.Arrays;

public class Median {


    public int [] mergeArrays(int[] arrayOne, int[] arrayTwo) {
        int [] mergedArray = new int[arrayOne.length + arrayTwo.length];
        int counter = 0;

        for(int index = 0; index < arrayOne.length; index++){
            mergedArray[counter] = arrayOne[index];
            counter++;
        }

        for(int index = 0; index < arrayTwo.length; index++){
            mergedArray[counter] = arrayTwo[index];
            counter++;
        }
        return mergedArray;
    }

    public double getMedianIn(int[] arrayOfNumbers) {
        if(arrayOfNumbers.length % 2 == 0){
            return (double) Math.round(((arrayOfNumbers[arrayOfNumbers.length / 2] + arrayOfNumbers[arrayOfNumbers.length / 2 - 1]) / 2.0) * 1000.0) / 1000;
        }
        return Math.round(arrayOfNumbers[arrayOfNumbers.length / 2 ] * 1000.0) / 1000.0;
    }


    public double getMedianOf(int[] arrayOne, int[] arrayTwo) {
        int [] mergedArray = mergeArrays(arrayOne,arrayTwo);
        Arrays.sort(mergedArray);
        return getMedianIn(mergedArray);
    }
}

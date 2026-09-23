public class LcmTwo {

    public int productOfLowestCommonMultiplesIn(int[] arrayOfNumbers) {
        int product = 1;
        int count = 2;

        boolean start = true;
        while(start){
            boolean divided = false;
            int counter = 0;
            for(int index = 0; index < arrayOfNumbers.length; index++){
                if(arrayOfNumbers[index] % count == 0){
                    arrayOfNumbers[index] = arrayOfNumbers[index] / count;
                    divided = true;
                }
                if(arrayOfNumbers[index] % count != 0){ counter++; }
            }

            if(divided){product *= count;}

            if(counter == arrayOfNumbers.length){count++;}

            if(areAllElementsOne(arrayOfNumbers)){ start = false;}

        }
        return product;
    }

    public boolean areAllElementsOne(int[] arrayOfNumbers) {
        int count = 0;
        for (int arrayOfNumber : arrayOfNumbers) {
            if (arrayOfNumber == 1) { count++; }
        }
        return count == arrayOfNumbers.length;
    }
}

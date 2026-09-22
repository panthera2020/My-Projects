public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for(int index = 0; index < numbers.length; index++) {
            for(int count = 0; count < numbers.length; count++) {
                if(index != count){
                    if(numbers[index] + numbers[count] == target) {
                        result[0] = index;
                        result[1] = count;
                        return result;
                    }
                }
            }
        }
        return null;
    }
}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoSumTest {

    @Test
    public void testThatWhenIGetAnArrayOfNumbersAndATargetNumberItReturnsTheIndexOfNumbersThatGetTheTargetValue() {
        TwoSum twoSum = new TwoSum();
        int [] numbers = {2,7,11,15};
        int target = 9;
        int [] expected = {0,1};
        assertArrayEquals(expected,twoSum.twoSum(numbers,target));
    }

    @Test
    public void testThatWhenIGetAnArrayOfNumbersAndATargetNumberItReturnsTheIndexOfNumbersThatGetTheTargetValue2() {
        TwoSum twoSum = new TwoSum();
        int [] numbersTwo = {3,2,4};
        int targetTwo = 6;
        int [] expectedTwo = {1,2};
        assertArrayEquals(expectedTwo,twoSum.twoSum(numbersTwo,targetTwo));
    }

    @Test
    public void testThatWhenIGetAnArrayOfNumbersAndATargetNumberItReturnsTheIndexOfNumbersThatGetTheTargetValue3() {
        TwoSum twoSum = new TwoSum();
        int [] numbersTwo = {3,3};
        int targetTwo = 6;
        int [] expectedTwo = {0,1};
        assertArrayEquals(expectedTwo,twoSum.twoSum(numbersTwo,targetTwo));
    }

}

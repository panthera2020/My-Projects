import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianTest {
    private Median median;

    @BeforeEach
    public void setUp() {
        median = new Median();
    }

    @Test
    public void testThatWhenIGetTwoArraysTheyAreMerged(){
        int[] arrayOne = {1,2,3,4};
        int[] arrayTwo = {5,6,7,8};
        int [] expected = {1,2,3,4,5,6,7,8};
        assertArrayEquals(expected, median.mergeArrays(arrayOne,arrayTwo));
    }

    @Test
    public void testThatWhenIGetAnArrayOfOddLengthIGetTheMedian(){
        int[] arrayOne = {1,2,3,4,5};
        assertEquals(3.0, median.getMedianIn(arrayOne));
    }

    @Test
    public void testThatWhenIGetAnArrayOfEvenLengthIGetTheMedian(){
        int[] arrayOne = {1,2,3,4,5,6};
        assertEquals(3.5, median.getMedianIn(arrayOne));
    }

    @Test
    public void testThatWhenIGetTwoArraysOfNumbersItIsMergedAndIGetTheMedian(){
        int[] arrayOne = {1,2,3,4};
        int[] arrayTwo = {5,6,7,8};
        assertEquals(4.5, median.getMedianOf(arrayOne,arrayTwo));
    }
}

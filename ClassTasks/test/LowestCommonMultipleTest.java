import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LowestCommonMultipleTest {
    private LowestCommonMultiple lowestCommonMultiple;

    @BeforeEach
    public void setUp(){
        lowestCommonMultiple = new LowestCommonMultiple();
    }

    @Test
    public void testThatWhenIGetANumberIGetAndArrayOfItsLcm(){
        int [] expected = {2,3};
        assertArrayEquals(expected, lowestCommonMultiple.getLowestCommonMultiples(6));
    }

    @Test
    public void testThatWhenIGetANumberIGetAndArrayOfItsLcm2(){
        int [] expected = {2,5};
        assertArrayEquals(expected, lowestCommonMultiple.getLowestCommonMultiples(10));
    }

    @Test
    public void testThatWhenIGetANumberIGetAndArrayOfItsLcm3(){
        int [] expected = {2,2,2,3};
        assertArrayEquals(expected, lowestCommonMultiple.getLowestCommonMultiples(24));
    }

    @Test
    public void testThatWhenIGetTwoArrays_ReturnsArrayWithLargestLength(){
        int [] firstArrayOfNumbers = {2,5};
        int [] secondArrayOfNumbers = {2,2,2,2,5};
        assertArrayEquals(secondArrayOfNumbers, lowestCommonMultiple.getLongestArray(firstArrayOfNumbers,secondArrayOfNumbers));
    }

    @Test
    public void testThatWhenIGetAnArrayOfNumbers_IAddNumbersNotInTheArrayToTheArray(){
        int [] firstArrayOfNumbers = {2,2,2,3};
        int [] secondArrayOfNumbers = {2,5};
        int [] expected = {2,2,2,3,5};
        assertArrayEquals(expected, lowestCommonMultiple.addElementsNotIn(firstArrayOfNumbers,secondArrayOfNumbers));
    }

    @Test
    public void testThatWhenIHaveAnArrayOfNumbersICanGetTheProductOfAllTheLowestCommonMultiples(){
        int [] arrayOfNumbers = {8,10,24};
        assertEquals(120, lowestCommonMultiple.getProductOfLowestCommonMultiples(arrayOfNumbers));
    }

}

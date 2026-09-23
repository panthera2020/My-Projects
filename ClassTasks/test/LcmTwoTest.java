import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LcmTwoTest {

    @Test
    public void testThatWhenIGetAnArrayOfNumbersIGetTheProductsOfItsCommonDivisors(){
        LcmTwo lcm = new LcmTwo();
        int [] arrayOfNumbers = {8,10,24};
        assertEquals(120, lcm.productOfLowestCommonMultiplesIn(arrayOfNumbers));
    }

    @Test
    public void testThatWhenAnArrayOfNumberAreAllOne_ReturnsTrue(){
        LcmTwo lcm = new LcmTwo();
        int [] arrayOfNumbers = {1,1,1,1,1,1,1};
        assertTrue(lcm.areAllElementsOne(arrayOfNumbers));
    }
}

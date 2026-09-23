import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LcmTest {

    @Test
    public void testThatWhenIGetTwoNumberIGetTheGreatestCommonDivisor(){
        Lcm lcm = new Lcm();
        assertEquals(2,lcm.getGreatestCommonDivisor(10,24));
    }
    @Test
    public void tesThatWhenIGetAnArrayOfNumbers_ReturnsProductOfTheGreatestCommonDivisor(){
        Lcm lcm = new Lcm();
        int [] arrayOfNumbers = {8,10,24};
        assertEquals(120,lcm.getProductOfGreatestCommonDivisor(arrayOfNumbers));
    }
}

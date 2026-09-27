import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseIntegerTest {

    @Test
    public void testThatWhenIGetAnIntegerItReturnsTheIntegerReversed(){
        ReverseInteger reverse = new ReverseInteger();
        assertEquals(321, reverse.reverseInt(123));
        assertEquals(21, reverse.reverseInt(120));
    }

    @Test
    public void testThatWhenIGetANegativeIntegerItReturnsTheIntegerReversedAndNegative(){
        ReverseInteger reverse = new ReverseInteger();
        assertEquals(-123, reverse.reverseInt(-321));
    }


}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostWaterTest {
    private MostWater mostWater;

    @BeforeEach
    public void setUp() {
        mostWater = new MostWater();
    }

    @Test
    public void testThatWhenIGetAnArrayOfNumbers_ReturnsMaxAreaThatCanContainTheMostWater(){
        int [] height = {1,8,6,2,5,4,8,3,7};
        assertEquals(49,mostWater.maxArea(height));
    }
}

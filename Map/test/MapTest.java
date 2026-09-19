import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    private MyMap map;

    @BeforeEach
    public void setUp() {
        map = new MyMap();
    }

    @Test
    public void testThatMapIsEmpty(){
        assertTrue(map.isEmpty());
    }

    @Test
    public void testThatICanIAddToMap(){
        map.put(10, "boy");
        assertFalse(map.isEmpty());
    }

    @Test
    public void testThatWhenIAddToMapIGetAtInstantTime(){
        map.put(10, "boy");
        assertEquals("boy",map.get(10));
    }
}

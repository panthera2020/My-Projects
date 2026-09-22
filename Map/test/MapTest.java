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
    public void testThatWhenIAddOneToMapIGetAtInstantTime(){
        map.put(10, "boy");
        assertEquals("boy",map.get(10));
    }

    @Test
    public void testThatThatICanAddMultipleElementsToMap(){
        map.put(10, "boy");
        assertEquals("boy",map.get(10));
        map.put(5, "girl");
        assertEquals("girl",map.get(5));
        map.put(3, "man");
        assertEquals("man",map.get(3));
    }

    @Test
    public void testThatWhenIAddMultipleElementToMap_WhenICheckReturnsTrueIfKeyIsInMap(){
        map.put(10, "boy");
        assertTrue(map.containsKey(10));
        map.put(5, "girl");
        assertTrue(map.containsKey(5));
    }

    @Test
    public void testThatCannotAddSameKeyTwice(){
        map.put(10, "boy");
        map.put(10, "girl");
        assertEquals("boy",map.get(10));
    }

    @Test
    public void testThatICanKeepAddingElements(){
        Object [] keys = {9,4,8,1,2,44,67,89,3,24,55,77,22};
        Object [] values = {"boy","girl","man","lol","dance","viva","stud","all","none","kiss","tell","ball","scuba"};

        for(int count = 0; count < keys.length; count++){
            map.put(keys[count], values[count]);
        }
        assertEquals("scuba",map.get(22));
    }

    @Test
    public void testThatWhenIAddKeyPairValues_AndIChechIfValueIsInMapReturnsTrueIfValueIsInMap(){
        map.put(10, "boy");
        map.put(5, "girl");
        assertTrue(map.containsValue("girl"));
        assertFalse(map.containsValue("ball"));
    }

    @Test
    public void testThatWhenIAddKeyPairValue_IGetTheSizeOfTheMap(){
        map.put(10, "boy");
        map.put(5, "girl");
        map.put(3, "man");
        assertEquals(3,map.getSize());
    }

    @Test
    public void testThatWhenIAddOneAndRemoveOneFromMap_MapIsEmpty(){
        map.put(10, "boy");
        assertFalse(map.isEmpty());
        map.remove(q10);
        assertTrue(map.isEmpty());
    }

    @Test
    public void testThatWhenIRemoveFromAEmptyMap_ErrorIsThrown(){
        assertThrows(IndexOutOfBoundsException.class, () -> map.remove(12));
    }

    @Test
    public void testThatWhenIRemoveFromMapAndKeyIsNotInMap_ErrorIsThrown(){
        map.put(10, "boy");
        assertThrows(IndexOutOfBoundsException.class, () -> map.remove(2));
    }

    @Test
    public void testThatWhenIAddToMapAndIReplaceKeyPair_ItIsReplaced(){
        map.put(10, "boy");
        map.put(5, "girl");
        map.replace(5,"sugar");
        assertEquals("sugar",map.get(5));
    }
}

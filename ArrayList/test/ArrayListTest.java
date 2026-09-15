import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    private MyArrayList arrayList;

    @BeforeEach
    public void setUp(){
        arrayList = new MyArrayList();
    }

    @Test
    public void testThatArrayListIsEmpty(){
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void tesThatICanIAddToArrayList(){
        arrayList.add(1);
        assertEquals(1,arrayList.get(0));
    }

    @Test
    public void tesThatWhenIAddToArrayList_ItAddsToEndOfArrayList(){
        arrayList.add(10);
        arrayList.add(20);
        assertEquals(20,arrayList.get(1));
        arrayList.add(30);
        assertEquals(30,arrayList.get(2));
    }

    @Test
    public void testThatICanKeepAddingElements(){
        Object element = 10;
        for(int index = 0; index < 105; index++){
            arrayList.add(element);
        }
        assertEquals(10,arrayList.get(100));
    }

    @Test
    public void testThatICanAddElementsAtSpecificIndex(){
        Object element = 10;
        for(int index = 0; index < 12; index++){
            arrayList.add(element);
        }
        arrayList.add(10, 12);
        assertEquals(12,arrayList.get(10));
    }

    @Test
    public void testThatWhenIAddElementToIndexBelowZero_ErrorIsThrown(){
        arrayList.add(10);
        arrayList.add(12);
        assertThrows(IndexOutOfBoundsException.class, ()-> arrayList.add(-1, 10));
    }

    @Test
    public void testThatWhenIAddElementToIndexAboveSize_ElementIsAddedToEndOfArrayList(){
        arrayList.add(10);
        arrayList.add(12);
        arrayList.add(6,13);
        assertEquals(13,arrayList.get(2));
    }
    @Test
    public void testThatICanGetTheSizeOfElementsAddedToArrayList(){
        Object element = 10;
        for(int index = 0; index < 12; index++){
            arrayList.add(element);
        }
        assertEquals(12,arrayList.size());
    }

    @Test
    public void testThatWhenIRemoveELementFromASpecificIndex_ElementIsRemoved(){
        arrayList.add(10);
        arrayList.add(12);
        arrayList.add(6);
        arrayList.remove(1);
        assertNull(arrayList.get(1));
    }

    @Test
    public void testThatWhenIRemoveAll_AllElementsAreRemoved(){
        arrayList.add(10);
        arrayList.add(12);
        arrayList.add(6);
        arrayList.removeAll();
        for(int index = 0; index < arrayList.size(); index++){
            assertNull(arrayList.get(index));
        }
    }
}

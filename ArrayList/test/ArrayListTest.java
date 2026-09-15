import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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


}

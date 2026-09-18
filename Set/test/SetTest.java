import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SetTest {
    private MySet set;

    @BeforeEach
    public void setUp() {
        set = new MySet();
    }

    @Test
    public void testThatArrayListIsEmpty(){
        assertTrue(set.isEmpty());
    }

    @Test
    public void tesThatICanIAddToSet(){
        set.add(1);
        assertFalse(set.isEmpty());
    }

    @Test
    public void tesThatICanIRemoveFromSet(){
        set.add(1);
        assertFalse(set.isEmpty());
        set.remove(1);
        assertTrue(set.isEmpty());
    }

    @Test
    public void testThatWhenIAddElementToSetAndITryToAddSimilarElementToSet_ElementIsNotAdded(){
        set.add(1);
        assertFalse(set.isEmpty());
        set.add(1);
        set.remove(1);
        assertTrue(set.isEmpty());
    }

    @Test
    public void testThatWhenIRemoveFromAnEmptySet_ErrorIsThrown(){
        assertThrows(IndexOutOfBoundsException.class, () -> set.remove(1));
    }

    @Test
    public void testThatWhenICheckForElement_ReturnsTrueIfElementIsInSet(){
        set.add(1);
        assertTrue(set.contains(1));
    }

    @Test
    public void testThatWhenICheckForElement_ReturnsFalseIfElementIsNotInSet(){
        set.add(1);
        assertFalse(set.contains(3));
    }
}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    private MyStack stack;

    @BeforeEach
    public void setUp() {
        stack = new MyStack();
    }

    @Test
    public void testThatStackIsEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testThatWhenIPush_StackIsNotEmpty() {
        assertTrue(stack.isEmpty());
        stack.push("Vdm");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testThatWhen_IPushOneAndPopOne_StackIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push("Vdm");
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testThatWhen_IPushTwoAndPopOne_IGetLastElement_StackIsNotEmpty() {
        assertTrue(stack.isEmpty());
        stack.push("Vdm");
        stack.push("Samosa");
        assertFalse(stack.isEmpty());
        assertEquals("Samosa", stack.pop());
        assertFalse(stack.isEmpty());

    }

    @Test
    public void testThatWhen_IPopEmptyStack_IGetException(){
        assertTrue(stack.isEmpty());
        assertThrows(IllegalArgumentException.class, () -> stack.pop());
        try {
            stack.pop();
        } catch (IllegalArgumentException e) {
            assertEquals("stack is empty", e.getMessage());
        }
    }

    @Test
    public void testThatWhen_IPushTwoAndPopTwo_IGetLastInFirstOut() {
        assertTrue(stack.isEmpty());
        stack.push("Vdm");
        stack.push("Samosa");
        assertFalse(stack.isEmpty());
        assertEquals("Samosa", stack.pop());
        assertEquals("Vdm", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testThatWhenIPushThreeAndPopThree_IGetLastInFirstOut() {
        assertTrue(stack.isEmpty());
        stack.push("Vdm");
        stack.push("Samosa");
        stack.push("Ronke");
        assertFalse(stack.isEmpty());
        assertEquals("Ronke", stack.pop());
        assertEquals("Samosa", stack.pop());
        assertEquals("Vdm", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testThatWhen_IPushFour_StackIsFull() {
        assertTrue(stack.isEmpty());
        stack.push("Vdm");
        stack.push("Samosa");
        stack.push("Ronke");
        assertThrows(IllegalArgumentException.class, () -> stack.push("Perez"));
        try {
            stack.pop();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Stack is full", e.getMessage());
        }
    }

    @Test
    public void testThatWhen_IPeekEmptyStack_IGetException(){
        assertTrue(stack.isEmpty());
        assertThrows(IllegalArgumentException.class, () -> stack.peek());
    }

    @Test
    public void testThatWhen_IPopOneAndPeek_IGetLastElementOnStack() {
        assertTrue(stack.isEmpty());
        stack.push("Vdm");
        assertEquals("Vdm", stack.peek());

    }

    @Test
    public void testThatWhen_IPushTwoAndPeek_IGetLastElementInStack(){
        assertTrue(stack.isEmpty());
        stack.push("Vdm");
        stack.push("Samosa");
        assertEquals("Samosa", stack.peek());
    }

}

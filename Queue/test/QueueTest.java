import MyQueue.MyQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    private MyQueue queue;

    @BeforeEach
    public void setUp() {
        queue = new MyQueue();
    }

    @Test
    public void testThatQueueIsEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testThatWhenIAddOneElementToQueue_QueueIsNotEmpty() {
        queue.add("Samosa");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testThatWhenIAddOneElement_AndRemoveOneElementInQueue_QueueIsEmpty() {
        queue.add("Samosa");
        assertEquals("Samosa",queue.remove());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testThatWhenIAddTwoElementsInQueue_AndIPeekIGetElementAtHeadOfQueue() {
        queue.add("Samosa");
        queue.add("Pie");
        assertEquals("Samosa", queue.peek());
    }

    @Test
    public void testThatWhenIAddThreeElementsInQueue_AndIPeekIGetElementAtHeadOfQueue() {
        queue.add("Samosa");
        queue.add("Pie");
        queue.add("Buns");
        assertEquals("Samosa", queue.peek());
    }

    @Test
    public void testThatWhenIAddThreeElementsToQueue_AndIRemoveElement_FirstElementIsRemovedFromQueue() {
        queue.add("Samosa");
        queue.add("Pie");
        queue.add("Buns");
        assertEquals("Samosa", queue.peek());
        assertEquals("Samosa",queue.remove());
        assertEquals("Pie", queue.peek());
    }

    @Test
    public void testThatWhenIAddThreeElementsInQueue_AndIPeekIRemoveTwice_FirstTwoElementsAreRemovedFromQueue() {
        queue.add("Samosa");
        queue.add("Pie");
        queue.add("Buns");
        assertEquals("Samosa", queue.peek());
        assertEquals("Samosa",queue.remove());
        assertEquals("Pie", queue.peek());
        assertEquals("Pie",queue.remove());
        assertEquals("Buns", queue.peek());
    }

    @Test
    public void testThatWhenIRemoveFromEmptyQueue_NothingHappens() {
        assertTrue(queue.isEmpty());
        queue.remove();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testThatWhenIPeekAtEmptyQueue_StackIsEmpty() {
        assertTrue(queue.isEmpty());
        assertNull(queue.peek());
    }

    @Test
    public void testThatWhenIAddToQueue_AndQueueIsFull_NothingHappens() {
        queue.add("Samosa");
        queue.add("Pie");
        queue.add("Buns");
        queue.add("Eggs");
    }
}

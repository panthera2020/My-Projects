import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    MyLinkedList linkedList;

    @BeforeEach
    public void setup() {
        linkedList = new MyLinkedList();
    }

    @Test
    public void testThatLinkedListIsEmpty() {
        assertNull(linkedList.head);
    }

    @Test
    public void testThatICanAddNodeToLinkedList() {
        linkedList.append(10);
        assertEquals(1,linkedList.size);
    }

    @Test
    public void testThatICanAddNodesToHead() {
        linkedList.append(10);
        linkedList.append(20);
        linkedList.append(30);
        assertEquals(3,linkedList.size);
    }

    @Test
    public void testThatWhenIAddNodesTheyAreInOrder() {
        linkedList.append(10);
        linkedList.append(20);
        assertEquals(20,linkedList.head.next.data);
    }

    @Test
    public void testThatWhenIPrependToLinkedListHeadIsUpdated() {
        linkedList.append(10);
        linkedList.append(20);
        linkedList.prepend(15);
        assertEquals(15,linkedList.head.data);
    }

    @Test
    public void testThatWhenIPrependToAnEmptyLinkedListHeadIsUpdated() {
        linkedList.prepend(15);
        assertEquals(15,linkedList.head.data);
    }

    @Test
    public void testThatWhenIInsertAtAnIndex_NodeIsAdded() {
        linkedList.append(10);
        linkedList.append(20);
        linkedList.append(30);
        linkedList.insertAt(15,1);
        assertEquals(15,linkedList.head.next.data);
    }

    @Test
    public void testThatWhenIInsertAtAnIndex0_NodeIsUpdated() {
        linkedList.append(10);
        linkedList.append(20);
        linkedList.insertAt(15,0);
        assertEquals(15,linkedList.head.data);
    }

    @Test
    public void testThatWhenIPopFromALinkedList_LastNodeIsRemoved() {
        linkedList.append(10);
        linkedList.append(20);
        linkedList.append(30);
        linkedList.pop();
        assertEquals(2,linkedList.size);
    }

    @Test
    public void testThatWhenIPopFromAnEmptyLinkedList_ErrorIsThrown() {
        assertThrows(NullPointerException.class, () -> linkedList.pop());
    }

    @Test
    public void testThatWhenIAddOne_AndPopOneFromALinkedList_NodeIsEmpty() {
        linkedList.append(10);
        linkedList.pop();
        assertEquals(0,linkedList.size);
    }

    @Test
    public void testThatWhenIInsertAtAnIndexGreaterThanSize_NodeIsNotAdded() {
        linkedList.append(10);
        linkedList.append(20);
        linkedList.append(30);
        linkedList.insertAt(15,5);
        assertEquals(3,linkedList.size);
    }

    @Test
    public void testThatWhenIInsertAtIndexLessThanZero_NodeIsNotAdded() {
        linkedList.append(10);
        linkedList.append(20);
        linkedList.append(30);
        linkedList.insertAt(15,-1);
        assertEquals(3,linkedList.size);
    }
}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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

}

public class MyLinkedList {
    Node head;
    int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            this.head = newNode;
        }else{
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        this.size++;
    }
}

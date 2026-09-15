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

    public void prepend(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            append(data);
        }else{
            Node current = head;
            head = newNode;
            newNode.next = current;
            this.size++;
        }
    }

    public void insertAt(int data, int index) {
        if(index == 0){
            prepend(data);
        }else{
            Node newNode = new Node(data);
            Node current = head;
            int count = 0;
            while (current.next != null){
                if (count == index -1){
                    Node temp = current.next;
                    current.next = newNode;
                    newNode.next = temp;
                }
                count++;
                current = current.next;
            }
        }
        this.size++;
    }

    public void pop() {
        if(size == 1){
            head = null;
        }else{
            Node current = head;
            while (current.next != null){
                current = current.next;
                if (current.next.next == null){
                    current.next = null;
                    break;
                }
            }
        }
        this.size--;
    }
}

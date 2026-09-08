package MyQueue;

public class MyQueue {
    private String [] queue = new String[3];
    private int count = 0;
    
    public boolean isEmpty() {return count == 0;}

    public void add(String element) {if (count < queue.length) {queue[count++] = element;}}

    public String remove() {
        String headOfQueue = queue[0];
        for(int index = 0; index < queue.length - 1; index++) {queue[index] = queue[index + 1];}
        if(count > 0) count--;
        return headOfQueue;
    }

    public String peek() {return queue[0];}
}
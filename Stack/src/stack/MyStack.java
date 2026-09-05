public class MyStack {
    private int count = 0;
    private String [] stack = new String[3];

    public boolean isEmpty() {
        return count == 0;
    }

    public void push(String element) {
        if (count == stack.length) {
            throw new IllegalArgumentException("Stack is full");
        }
        stack[count++] = element;
    }

    public String pop() {
        if(isEmpty()){
            throw new IllegalArgumentException("stack is empty");
        }
        String lastElement = stack[--count];
        return lastElement;
    }

    public String peek() {
        if(isEmpty()){
            throw new IllegalArgumentException("stack is empty");
        }
        String lastElementInStack = stack[count - 1];
        return lastElementInStack;
    }
}

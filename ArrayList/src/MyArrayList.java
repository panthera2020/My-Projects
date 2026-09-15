public class MyArrayList {
    private Object[] elements = new Object[10];
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Object element){
        if(size == elements.length - 1){
            Object[] temp = new Object[elements.length*2];
            this.elements = temp;
            elements[size++] = element;
        }else{
            elements[size++] = element;
        }

    }
    public Object get(int index){
        return elements[index];
    }


}

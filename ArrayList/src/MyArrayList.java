public class MyArrayList {
    private Object[] elements = new Object[10];
    private int size = 0;

    public boolean isEmpty() { return size == 0; }

    public void add(Object element){
        if(size == elements.length - 1){
            this.elements = new Object[elements.length*2];
            elements[size++] = element;
        }else{ elements[size++] = element; }
    }
    public Object get(int index){ return elements[index];}

    public void add(int index, Object element) {
        if(index > size - 1){ add(element);}
        else{ elements[index] = element; }
    }

    public int size(){ return size; }

    public void remove(int index) { elements[index] = null;}

    public void removeAll() {
        for(int index = 0; index < size; index++){ elements[index] = null; }
    }
}

import java.util.ArrayList;
import java.util.List;

public class MySet {
    private List<Object> set = new ArrayList<Object>();
    private int size = 0;

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int element) {
        if(!contains(element)){
            set.add(element);
            size++;
        }
    }

    public boolean contains(Object element) {
        boolean inSet = false;
        for(Object objectIn : set){
            if(objectIn.equals(element)){
                inSet = true;
            }
        }
        return inSet;
    }

    public void remove(Object element) {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }else{
            for(Object objectIn : set){
                if(objectIn.equals(element)){
                    set.remove(objectIn);
                    size--;
                    break;
                }
            }
        }
    }

    public void clear() {
        set.clear();
        size = 0;
    }
}

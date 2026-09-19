import java.util.ArrayList;
import java.util.List;

public class MyMap {
    private List<Object []> mapElements = new ArrayList<>();
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(Object key, Object value) {
        Object [] newElement = {key, value};
        mapElements.add(newElement);
        size++;
    }

    public Object get(Object key) {
        return mapElements.get(key.hashCode() % mapElements.size())[1];
    }
}

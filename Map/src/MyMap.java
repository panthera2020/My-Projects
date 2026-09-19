import java.util.Objects;

public class MyMap {
    private Object [][] mapElements = new Object[5][2];
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(Object key, Object value) {
        if (size == mapElements.length) {
            Object[][] temp = new Object[mapElements.length*2][2];
            for (Object[] mapElement : mapElements) {
                if (mapElement[0] != null) {
                    int newIndex = mapElement[0].hashCode() % temp.length;
                    temp[newIndex][0] = mapElement[0];
                    temp[newIndex][1] = mapElement[1];
                }
            }
            this.mapElements = temp;
        }else{
            if(!containsKey(key)){
                int index = key.hashCode() % mapElements.length;
                mapElements[index][0] = key;
                mapElements[index][1] = value;
                size++;
            }
        }
    }

    public Object get(Object key) {
        return mapElements[key.hashCode() % mapElements.length][1];
    }

    public boolean containsKey(Object key) {
        return Objects.equals(mapElements[key.hashCode() % mapElements.length][0], key);
    }


    public boolean containsValue(Object value) {
        for (Object[] mapElement : mapElements) {
            if (Objects.equals(mapElement[1], value)) { return true; }
        }
        return false;
    }

    public int getSize() {return size; }

    public void remove(Object key) {
        if(isEmpty() || !containsKey(key)){ throw new IndexOutOfBoundsException();}
        else{
            int index = key.hashCode() % mapElements.length;
            mapElements[index][1] = null;
            mapElements[index][0] = null;
            size--;
        }
    }

    public void replace(Object key, Object value) {
        int index = key.hashCode() % mapElements.length;
        mapElements[index][1] = value;
    }
}

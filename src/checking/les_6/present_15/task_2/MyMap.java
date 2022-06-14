package checking.les_6.present_15.task_2;


import java.util.*;

public class MyMap<K, V extends List<E>, E> {

    private final Map<K,V> map = new HashMap<>();
    public MyMap() {
    }

    public void add(K key, V value) {
        map.put(key, value);
    }

    public void add(K key) {
        map.put(key, null);
    }

    public void addAcc(K key, E elem) {
        if (map.get(key) != null) {
            map.get(key).add(elem);
        } else {
            List<E> list = new ArrayList<>(Collections.singletonList(elem));
            map.put(key, (V) list);
//            map.put(key, (V) new ArrayList<>(List.of(elem)));
        }
    }

    public void remove(K key) {
        map.remove(key);
    }
    public void removeAcc(K key, E elem) {
        map.get(key).remove(elem);
    }
    public void showMap(){
        map.forEach((key, value) -> System.out.printf("%s :: %s%n", key, value));
    }
}

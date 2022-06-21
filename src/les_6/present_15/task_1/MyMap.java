package les_6.present_15.task_1;

import java.util.HashMap;
import java.util.Map;

public class MyMap<K, V> {

    private final Map<K, V> map = new HashMap<>();

    public MyMap() {
    }

    public void add (K key, V value) {
        map.put(key, value);
    }

    public void remove(K key) {
        map.remove(key);
    }

    public void remove(K key, V value) {
        map.remove(key, value);
    }

    public void removeAcc(K key) {
        map.put(key, null);
    }

    public void showAll() {
        map.forEach((key, value) -> System.out.printf("%s :: %s%n", key, value));
    }

}

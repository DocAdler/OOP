package les_6.present_15.task_3;

import java.util.*;

public class ZooClub <K extends Person, V extends List<Animal>>{

    Map<K,V> map = new HashMap<>();

    public ZooClub() {
    }

    public void addPerson(K key) {
        map.put(key,null);
    }

    public void addPerson(K key, V value) {
        map.put(key, value);
    }

    public void addAnimal(K key, Animal value) {
        if (map.get(key) != null) {
            map.get(key).add(value);
        } else {
            V list = (V) new ArrayList<>(Collections.singletonList(value));
            addPerson(key, list);
        }
    }

    public void removePerson(K key) {
        map.remove(key);
    }

    public void removeAnimal(K key, Animal animal) {
        map.get(key).remove(animal);
    }

    public void showClub(){
        if (map.isEmpty()) {
            System.out.println("Club is empty.");

        } else {
            map.forEach((key, value) -> {
                System.out.println(key + " владеет:");
                value.forEach(System.out::println);
                System.out.println();;
            });
        }
    }
}

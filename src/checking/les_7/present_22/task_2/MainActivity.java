/*
Створити будь-який клас-модель.
Зробити Optional<Class-model> використати методи з попередніх презентацій.
 */

package checking.les_7.present_22.task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainActivity {
    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>(List.of(
                new Person("Andrew"),
                new Person("Mike"),
                new Person(),
                new Person("Sam"),
                new Person("Tom")
        ));

        List<Optional<Person>> optionalList = new ArrayList<>();

        personList.forEach(elem -> optionalList.add(Optional.ofNullable(elem)));

        optionalList.forEach(optPerson -> optPerson.ifPresent(person -> System.out.println(person.getName())));

        System.out.println("------------------------");

        optionalList.forEach(person -> person.map(Person::getName).ifPresent(System.out::println));

        System.out.println("------------------------");

        optionalList.forEach(person -> {
            if (person.map(Person::getName).isPresent()) {
                System.out.println("Not empty");
            } else {
                System.out.println("Empty");
            }
        });
    }
}

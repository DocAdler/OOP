/*
Task 1:
Завдання : відфільтрувати слова у яких більше ніж 4 букви.

Task 2:
Завдання : зробити так, щоб стрічки у List<String> були у верхньому регістрі.

Task 3;
Завдання: зробити клас Person, який має ім’я(можна та інші), зробити список людей,
посортувати їх за допомогою компаратора.

Task 4:
Завдання: зробити клас Person, який має ім’я(можна та інші), зробити список людей,
посортувати їх за допомогою компаратора та зберегти результат в іншу колекцію.

Task 5:
Завдання: зробити клас Person, який має ім’я(можна та інші), зробити список людей,
посортувати їх за допомогою компаратора та вивести перший(min) та останній (max) елементи.
 */

package les_8.preset_23.task_1;

import java.util.*;

public class MainActivity {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("three", "four", "seven", "eight", "four"));

        //Task 1:
        System.out.println("-------------------Task 1-------------------");
        list.stream().filter(elem -> elem.contains("ee")).forEach(System.out::println);

        //End Task 1.

        //Task 2:
        System.out.println("-------------------Task 2-------------------");
        list.stream().map(elem -> elem.toUpperCase(Locale.ROOT)).forEach(System.out::println);
        //End Task 2.

        //Task 3:
        System.out.println("-------------------Task 3-------------------");
        List<Person> personList = new ArrayList<>(List.of(
                new Person("Andrew", 21),
                new Person(25),
                new Person("Mike", 18),
                new Person(),
                new Person("Sam", 25),
                new Person("Tom", 20),
                new Person("Billy")
        ));

        personList.stream().peek(elem -> {
            if (elem.getName() == null) {
                elem.setName("Empty name");
            }
            if (elem.getAge() == null) {
                elem.setAge(0);
            }
        }).sorted(Comparator.comparing(Person::getName).thenComparingInt(Person::getAge)).forEach(System.out::println);
        //End Task 3.

        //Task 4
        System.out.println("-------------------Task 4-------------------");
        List<Person> personListShort = new ArrayList<>(List.of(
                new Person("Andrew", 21),
                new Person("Mike", 18),
                new Person("Sam", 25),
                new Person("Tom", 20)
        ));
        List<Person> sortedPersonListCollect = personListShort.stream().sorted(Comparator.comparing(Person::getName).thenComparingInt(Person::getAge)).toList();
        sortedPersonListCollect.forEach(System.out::println);
        //End Task 4.

        //Task 5:
        System.out.println("-------------------Task 5-------------------");
        Person min = personListShort.stream().min(Comparator.comparing(Person::getName).thenComparingInt(Person::getAge)).get();

        Person max = personListShort.stream().max(Comparator.comparing(Person::getName).thenComparingInt(Person::getAge)).get();

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);

        //End Task 5.
        //Testing:
        System.out.println("-------------------skip()-------------------");
        list.stream().skip(list.size() - 2).forEach(System.out::println);
        System.out.println("-------------------distinct()-------------------");
        list.stream().distinct().forEach(System.out::println);
        System.out.println("-------------------limit()-------------------");
        list.stream().limit(2).forEach(System.out::println);



    }
}

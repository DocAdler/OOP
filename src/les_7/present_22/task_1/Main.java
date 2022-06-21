/*
Створити клас Person з полями вік, ім’я, timestamp.
Зробити конструктор і включити в нього 2 поля вік та ім’я.

1. Написати лямбда-функцію, яка для кожного елемента(елементом є користувач)
листа перевіряє вік, і повнолітніх заносить в інший лист.

Написати лямбда-функцію, яка для кожного елемента листа(List<Person>)
встановлює (setDate) поле поточна дата.

Написати лямбда-функцію яка перебирає кожен елемент списку (List<String>)
і записує в інший лист довжини листів з першого списку.
 */

package les_7.present_22.task_1;

import java.util.*;

import static java.lang.System.out;

public class Main {

    static List<Person> list18 = new ArrayList<>();
    static List<Integer> stringLength = new ArrayList<>();

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>(List.of(
                new Person("Andrew", 21),
                new Person("Tom", 17),
                new Person("Sam", 18),
                new Person("Mike", 25),
                new Person("Billy", 14)
        ));

        ageChecker(personList);
        list18.forEach(out::println);
        out.println("--------------");

        setDate(personList);
        personList.forEach(out::println);

        List<String> stringList = new ArrayList<>(List.of(
                "one",
                "two",
                "three",
                "four",
                "five"
        ));

        out.println("--------------");
        stringLength(stringList);
        stringLength.forEach(out::println);
    }

    public static void ageChecker(List<Person> list) {
        list.stream().filter(elem -> elem.getAge() >= 18).forEach(elem -> list18.add(elem));
    }

    public static void setDate(List<Person> list){
        list.forEach(elem -> elem.setCalendar(new GregorianCalendar()));
    }

    public static void stringLength(List<String> list) {
        list.forEach(elem -> stringLength.add(elem.length()));
    }
}

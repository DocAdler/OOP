/*
Створити клас Person з полями вік, ім’я, timestamp.
Зробити конструктор і включити в нього 2 поля вік та ім’я.

1. Написати лямбда-функцію, яка для кожного елемента(елементом є користувач)
листа перевіряє вік, і повнолітніх заносить в інший лист.

2. Написати лямбда-функцію, яка для кожного елемента листа(List<Person>)
встановлює (setDate) поле поточна дата.

3. Написати лямбда-функцію яка перебирає кожен елемент списку (List<String>)
і записує в інший лист довжини листів з першого списку.
 */

package les_7.present_22.task_1_var_2;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>(List.of(
                new Person("Andrew", 21),
                new Person("Tom", 17),
                new Person("Sam", 18),
                new Person("Mike", 25),
                new Person("Billy", 14)
        ));

        //1
        List<Person> list1 = personList.stream().filter(elem -> elem.getAge() >= 18).toList();
        System.out.println(list1);

        //2
        personList.forEach(person -> person.setCalendar(new GregorianCalendar()));
        System.out.println(personList);

        //3
        List<Integer> list2 = personList.stream()
                .mapToInt(value -> value.getName().length())
                .boxed()
                .toList();
        System.out.println(list2);
    }
}

/*
�������� ���� Person � ������ ��, ���, timestamp.
������� ����������� � �������� � ����� 2 ���� �� �� ���.

1. �������� ������-�������, ��� ��� ������� ��������(��������� � ����������)
����� �������� ��, � ��������� �������� � ����� ����.

2. �������� ������-�������, ��� ��� ������� �������� �����(List<Person>)
���������� (setDate) ���� ������� ����.

3. �������� ������-������� ��� �������� ����� ������� ������ (List<String>)
� ������ � ����� ���� ������� ����� � ������� ������.
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

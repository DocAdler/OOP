/*
���� �������� ���� People (� ������ name - ��'�, age - ��, sex - �����)

1. ������� �������-�������������'������ (�� 18 �� 27 ����)
2. ������ ������� �� ����� �������
3. ������ ������� ���������� ������������ ����� � ������
    (����� �� 18 ���� � � ������ �� �� ���� �������� � 55 ����, � ������ � 60)
4. ³���������� �������� ����� �� ��'�� � ���������� ���������� �������
5. ³���������� �������� ����� �������� �� ����, � ���� �� ����
6. ������ ��������� ������
7. ������ ���������� ������
8. ������� ������ � �������
9. ������� ������ � ����
10. ������� ��� ���� � ���� ��� ���������� �� �A�
 */

package les_8.preset_23.task_3;

import java.util.*;

public class MainActivity {
    public static void main(String[] args) {

        Collection<People> people = new ArrayList<>(List.of(
                new People("Andrew", 25, "man"),
                new People("Mike", 16, "man"),
                new People("Sam", 18, "man"),
                new People("Tom", 20, "man"),
                new People("John", 60, "man"),
                new People("Billy", 65, "man"),
                new People("Ann", 18, "woman"),
                new People("Sahra", 20, "woman"),
                new People("Samanta", 16, "woman"),
                new People("Agnes", 55, "woman"),
                new People("Elizabeth", 57, "woman")
        ));

        //1
        people.stream().filter(elem -> elem.getSex().equals("man") & (elem.getAge() >= 18 & elem.getAge() <= 27))
                .forEach(System.out::println);
        System.out.println("------------------------");

        //2
        double resDouble = people.stream().mapToDouble(People::getAge).average().orElse(0);
        int resInt = (int) resDouble;
        if (resDouble / resInt == 1) {
            System.out.println(resInt);
        } else {
            System.out.println(resDouble);
        }
        System.out.println("------------------------");

        //3
        people.stream().filter(elem -> {
            if (Objects.equals(elem.getSex(), "man") & (elem.getAge() >= 18 & elem.getAge() <=60)) {
                return true;
            } else return Objects.equals(elem.getSex(), "woman") & (elem.getAge() >= 18 & elem.getAge() <= 55);
        }).forEach(System.out::println);
        System.out.println("------------------------");

        //4
        people.stream().sorted(Comparator.comparing(People::getName).reversed()).forEach(System.out::println);
        System.out.println("------------------------");

        //5
        people.stream().sorted(Comparator.comparing(People::getName).thenComparingInt(People::getAge))
                .forEach(System.out::println);
        System.out.println("------------------------");

        //6
        People personMax = people.stream().max(Comparator.comparing(People::getAge)).get();
        System.out.println(personMax);
        System.out.println("------------------------");

        //7
        People personMin = people.stream().min(Comparator.comparing(People::getAge)).get();
        System.out.println(personMin);
        System.out.println("------------------------");

        //8
        Long countMan = people.stream().filter(elem -> elem.getSex().equals("man")).count();
        System.out.println(countMan);
        System.out.println("------------------------");

        //9
        Long countWoman = people.stream().filter(elem -> elem.getSex().equals("woman")).count();
        System.out.println(countWoman);
        System.out.println("------------------------");

        //10
        people.stream().filter(elem -> elem.getName().startsWith("A")).forEach(System.out::println);
        System.out.println("------------------------");
    }
}
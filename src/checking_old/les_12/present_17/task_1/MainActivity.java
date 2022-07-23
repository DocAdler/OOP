/*
���������� ������ � Comparator ���, ��� ����������������� anonymous classes , ������ ��������� �����������-�����.
�������� � ����������� 13 / les_5: ���������� ���������� �ᒺ��� ���� User �� �������� ������ (����������� Comparator)
 */

package checking_old.les_12.present_17.task_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainActivity {

    public static void main(String[] args) {
        List<User> usersList = new ArrayList<>(List.of(
                new User("Sam","sam95@gmail.com"),
                new User("Sam","sam199@gmail.com"),
                new User("Andrew","and222246546@gmail.com"),
                new User("Tom","tom2000@gmail.com"),
                new User("Tom","tom1999@gmail.com")

        ));

        Comparator<User> comparator = (user1, user2) -> user1.getEmail().length() - user2.getEmail().length();

        usersList.sort(comparator);
        usersList.forEach(System.out::println);
    }
}

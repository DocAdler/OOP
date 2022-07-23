/*
Завдання : Реалізувати сортування об’єктів типу User за довжиною емейла (використати Comparator)
 */

package checking.les_5.present_13.task_3;

import java.util.ArrayList;
import java.util.List;

public class MainActivity {
    public static void main(String[] args) {

        List<Users> usersList = new ArrayList<>(List.of(
                new Users("Sam","sam95@gmail.com"),
                new Users("Sam","sam99@gmail.com"),
                new Users("Andrew","and@gmail.com"),
                new Users("Tom","tom2000@gmail.com"),
                new Users("Tom","tom1999@gmail.com")

        ));

        usersList.sort(new UsersComparator());
        usersList.forEach(System.out::println);
    }
}

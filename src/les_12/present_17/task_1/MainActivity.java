/*
Переробити задачі з Comparator так, щоб використовувалися anonymous classes , замість створення компаратора-класу.
Завдання з презентації 13 / les_5: Реалізувати сортування об’єктів типу User за довжиною емейла (використати Comparator)
 */

package les_12.present_17.task_1;

import java.util.*;

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

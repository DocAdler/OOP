/*
Реалізувати сортування об`єктів типу
 User за параметром : userName, якщо userName однаковий, сортувати за userAge,
 якщо userAge однаковий сортувати за emailAddress. (Comparable)
 */

package checking.les_5.present_13.task_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity {
    public static void main(String[] args) {

        List<User> userList = new ArrayList<>(List.of(
                new User("Sam","sam95@gmail.com"),
                new User("Sam", "sam99@gmail.com"),
                new User("Andrew", "andrew@gmail.com"),
                new User("Tom", "tom2000@gmail.com"),
                new User("Tom", "tom1999@gmail.com")
        ));

        Collections.sort(userList);
        userList.forEach(System.out::println);
    }
}

/*
Завдання : Реалізувати сортування об’єктів типу
 User за параметром : userName, якщо userName однаковий, сортувати за userAge,
 якщо userAge однаковий сортувати за emailAddress. (Comparable)
 */

package checking.les_5.present_14.task_1;

import java.util.HashSet;
import java.util.Set;

public class MainActivity {
    public static void main(String[] args) {

        Set<User> userSet = new HashSet<>();
        userSet.add(new User("A", 2, "A"));
        userSet.add(new User("A", 3, "A"));
        userSet.add(new User("A", 1, "A"));

        for (User user : userSet) {
            System.out.println(user);
        }
    }
}
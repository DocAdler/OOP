/*
Створіть функціональний інтерфейс із методом, який приймає три значення int та повертає значення int.
Створіть лямбда-функції (як змінні в основному методі), що реалізує цей інтерфейс:
1. Перша лямбда повертає максимальне значення
2. Друга - середнє значення
3. Третя - суму всіх трьох значень
Викликати ці лямбди.

 */

package les_7.present_22.task_3;

import java.util.Comparator;
import java.util.stream.Stream;

public class MainActivity {
    public static void main(String[] args) {

        //1
        MyLambda lambda1 = (x, y, z) -> {
            Stream<Integer> stream = Stream.of(x, y, z);
            return stream.max(Comparator.comparingInt(o -> o)).orElse(0);
        };

        //2
        MyLambda lambda2 = (x, y, z) -> {
          int min = Stream.of(x, y, z).min(Integer::compare).orElse(0);
          int max = Stream.of(x, y, z).max(Integer::compare).orElse(0);

          if (x != min & x != max) return x;
          else if (y != min & y != max) return y;
          else return z;
        };

        MyLambda lambda3 = (x, y, z) -> Stream.of(x, y, z).mapToInt(Integer::intValue).sum();

        System.out.println(lambda1.test(1, 3, 5));
        System.out.println(lambda2.test(1, 3, 5));
        System.out.println(lambda3.test(1, 3, 5));
    }
}

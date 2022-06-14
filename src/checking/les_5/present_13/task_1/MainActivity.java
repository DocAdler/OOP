/*
Створити лист елементів типу int, ініціалізувати його (записати декілька елементів).
за допомогою ListIterator змінити значення елементів (наприклад всі помножити на 5, або до всіх додати 1);
вивести на екран всі значення з початку до кінця (за допомогою Iterator);
вивести на екран всі значення з кінця на початок (за допомогою ListIterator).

 */

package checking.les_5.present_13.task_1;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MainActivity {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 20; i++) list.add(i);
        System.out.println(list);

        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            listIterator.set(listIterator.next() * 5);
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

        System.out.println();

        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
    }
}

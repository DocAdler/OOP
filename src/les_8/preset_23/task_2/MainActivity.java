/*
Дана колекція стрічок : “One”, “Two”, “Three”, “Four”, “Five”, “One”.

1. Повернути кількість входжень об'єкта «One»
2. Повернути перший елемент колекції або 0, якщо колекція порожня
3. Повернути останній елемент колекції або «empty», якщо колекція порожня
4. Знайти елемент в колекції рівний «Three» або кинути помилку
5. Повернути третій елемент колекції по порядку
6. Повернути два елементи починаючи з другого
7. Вибрати всі елементи в яких є більше ніж 3 букви у слові
8. Повернути колекції без дублікатів
9. Знайти чи існують хоч один «One» елемент в колекції
10. Знайти чи є символ «o» у всіх елементів колекції
11. Додати "_1" до кожного елементу колекції
12. Відсортувати колекцію рядків за алфавітом і прибрати дублікати


 */
package les_8.preset_23.task_2;

import java.util.*;

public class MainActivity {
    private static final List<String> list = new ArrayList<>(Arrays.asList("One", "Two", "Three", "Four", "Five", "One"));

    public static void main(String[] args) {

        //1
        Long count = list.stream().filter(elem -> elem.equals("One")).count();
        System.out.println(count);

        //2
        String firstElem = list.stream().findFirst().orElse("0");
        System.out.println(firstElem);

        //3
        String lastElem = list.stream().skip(list.size()-1).findAny().orElse("Empty");
        System.out.println(lastElem);

        //4
        String str = "Three";
        String three = list.stream().filter(elem -> elem.equals(str)).findAny()
                .orElseThrow(() -> new RuntimeException(str + " not found"));
        System.out.println(three);

        //5
        String fiveElem = list.stream().skip(4).findFirst().orElse("Not found");
        System.out.println(fiveElem);

        //6
        String[] array = list.stream().limit(3).skip(list.size()-5).toArray(String[]::new);
        System.out.println(Arrays.toString(array));

        //7
        String[] array2 = list.stream().filter(elem -> elem.length()>3).toArray(String[]::new);
        System.out.println(Arrays.toString(array2));

        //8
        String[] array3 = list.stream().distinct().toArray(String[]::new);
        System.out.println(Arrays.toString(array3));

        //9
        boolean b = list.stream().anyMatch(elem -> elem.equals("One"));
        System.out.println(b);

        //10
        boolean b1 = list.stream().allMatch(elem -> elem.contains("o"));
        System.out.println(b1);

        //11
        list.stream().map(elem -> elem + "_1").forEach(System.out::println);

        //12
        list.stream().sorted(String::compareTo).distinct().forEachOrdered(System.out::println);
    }
}

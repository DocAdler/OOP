/*
Створити власну анотацію, якою можна анотувати методи та поля класу,
яка буде описана в JavaDoc та використовуватися у Runtime. Анотація має мати 1 або більше параметрів.
Створити власний клас (будь-який) і анотувати все, що можна

 */

package checking.les_9.task_1;


import java.util.HashMap;
import java.util.Map;

public class MainActivity {

    @MyAnnot(name = "Map", value = 0)
    private static final Map<Integer, String> map = new HashMap<>();

    @MyAnnot(name = "Main", value = 1)
    public static void main(String[] args) {

        map.put(1, "one");

        @MyAnnot(name = "Entry", value = 2)
        String entry = String.valueOf(map.entrySet());

        System.out.println(entry);
    }

    @MyAnnot(name = "Method", value = 3)
    public static void method(Map<Integer, String> map) {

    }
}

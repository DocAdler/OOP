/*
���� �������� ������ : �One�, �Two�, �Three�, �Four�, �Five�, �One�.

1. ��������� ������� �������� ��'���� �One�
2. ��������� ������ ������� �������� ��� 0, ���� �������� �������
3. ��������� ������� ������� �������� ��� �empty�, ���� �������� �������
4. ������ ������� � �������� ����� �Three� ��� ������ �������
5. ��������� ����� ������� �������� �� �������
6. ��������� ��� �������� ��������� � �������
7. ������� �� �������� � ���� � ����� �� 3 ����� � ����
8. ��������� �������� ��� ��������
9. ������ �� ������� ��� ���� �One� ������� � ��������
10. ������ �� � ������ �o� � ��� �������� ��������
11. ������ "_1" �� ������� �������� ��������
12. ³���������� �������� ����� �� �������� � �������� ��������


 */
package checking.les_8.preset_23.task_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

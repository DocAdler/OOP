/*
�������� ������ ��������, ���� ����� ��������� ������ �� ���� �����,
��� ���� ������� � JavaDoc �� ����������������� � Runtime. �������� �� ���� 1 ��� ����� ���������.
�������� ������� ���� (����-����) � ��������� ���, �� �����

 */

package les_9.task_1;


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

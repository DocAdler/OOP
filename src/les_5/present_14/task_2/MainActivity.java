/*
Створити клас (будь який), описати в ньому мінімум два поля, одне з яких String,
інше числове (довільно яке). Створити в мейн методі Set. Наповнити його об’єктами даного класу.
Вивести спершу невідсортований список,
потім відсортований на консоль(використати Comparable для сортування за цими полями);
 */

package les_5.present_14.task_2;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MainActivity {
    public static void main(String[] args) {

        Set<Student> studentSet = new TreeSet<>(List.of(
                new Student("Andrew", 380972162428L),
                new Student("Tomas", 380934935126L),
                new Student("Sam", 380679821526L),
                new Student("Billy", 380500301265L),
                new Student("Billy", 380630311265L)
        ));

        for (Student student : studentSet) {
            System.out.println(student);
        }
    }
}

/*
Мінімум:
1.Створити власну анотацію, яка буде приймати хоча б один параметр.
Створити клас із певними полями і над декількома полями написати власну анотацію.
Створити метод який буде записувати поля класу які промарковані анотацією в файл(рефлексія).

Максимум:
https://www.baeldung.com/java-datetimeformatter
Створити методи які дозволять конвертувати дату з
Date --> LocalDate.
Date --> LocalTime,
Date --> LocalDateTime

 */

package les_9.task_2;

import java.io.*;
import java.util.*;
import java.lang.reflect.Field;

public class MainActivity {

    static String dir = "src\\les_9\\task_2\\fields";
    static String name1 = "resultSimple";
    static String name2 = "resultInMap";


    public static void main(String[] args) throws IOException {

        fileWriter(dir, name1, fieldsExtractor(Fields.class));
        fileWriter(dir, name2, fieldsExtractorToMap(Fields.class));
    }

    private static List<String> fieldsExtractor(Class<?> className) {

        List<String> listFields = new ArrayList<>();

        Field[] fields = className.getDeclaredFields();
//Variant 1:
        Arrays.stream(fields).toList().stream()
                .map(field -> {
                    if (field.getAnnotation(Write.class).toWrite()) return field;
                    else return null;
                }).filter(Objects::nonNull).map(Object::toString)
                .forEach(listFields::add);
        return listFields;
//Variant 2:
//        for (Field field : fields) {
//            Write annot = field.getAnnotation(Write.class);
//            if (annot.toWrite()) {
//                listFields.add(field.toString());
//            }
//        }
    }

    private static void fileWriter(String dir, String name, List<String> listFields) throws IOException {
        boolean root = new File(dir).mkdirs();
        boolean file = new File(dir, name).createNewFile();

        if (file || root) {
            PrintStream ps = new PrintStream(new File(dir, name));
            listFields.forEach(ps::println);
            ps.close();
            System.out.println("Writing completed");
        } else {
            System.out.println("File already or not created");
        }
    }

    private static Map<Integer, String> fieldsExtractorToMap(Class<?> className) {

        Map<Integer, String> map = new TreeMap<>();

        Field[] fields = className.getDeclaredFields();
//Variant 1:
        Arrays.stream(fields).toList().stream()
                .map(field -> {
                    if (field.getAnnotation(Write.class).toWrite()) return field;
                    else return null;
                }).filter(Objects::nonNull)
                .forEach(field -> {
                    int key = field.getAnnotation(Write.class).value();
                    map.put(key,field.toString());
                });
        return map;
//Variant 2:
//        for (Field field : fields) {
//            Write annot = field.getAnnotation(Write.class);
//            if (annot.toWrite()) {
//                map.put(annot.value(), field.toString());
//            }
//        }
    }

    private static void fileWriter(String dir, String name, Map<Integer, String> map) throws IOException {
        boolean root = new File(dir).mkdirs();
        boolean file = new File(dir, name).createNewFile();

        if (file || root) {
            PrintStream ps = new PrintStream(new File(dir, name));
            map.entrySet().forEach(ps::println);
            ps.close();
            System.out.println("Writing completed");
        } else {
            System.out.println("File already or not created");
        }
    }
}
package les_9.task_my_0;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * <b> Функционал: </b> <p>
 * Анализ классов на предмет наличия аннотации @Run:<p>
 *      Если @Run.toRun() == true -> Передача объектов этих классов в List(Object);<p>
 *      Если @Run.toRun() == false -> Игнорирование; <p>
 * <p>
 * Анализ методов с аннотацией @Invoke;<p>
 *     Если @Invoke.toInvoke() == true -> Визов методов объектов в порядке @Invoke.orderNum(); <p>
 *     Если @Invoke.toInvoke() == false -> Игнорирование;
 */

public class MainActivity {

    private static final ArrayList<Object> objectList = new ArrayList<>();

    public static void main(String[] args) {

        invokeMethodsOf(
                Print1.class,
                Print2.class,
                Print3.class,
                Print4.class,
                Print5.class);
    }


    /**
     * Структурирует в {@code List<Class<?>>}, сортирует по {@code @Run.orderNum} и передает в {@code objMaker()};
     * @param classes Принимает массив классов: {@code Class<?>}:
     */
    private static void invokeMethodsOf(Class<?>...classes) {
        classCollector(classes).forEach(MainActivity::objMaker);

        objectList.stream()
                .sorted(Comparator.comparingInt(obj -> obj.getClass().getAnnotation(Run.class).orderNum()))
                .forEach(MainActivity::invoker);
    }


    /**
     * @param classes принимает неопределенное количество объектов типа Class;
     * @return Лист классов;
     */
    private static List<Class<?>> classCollector(Class<?>...classes) {
        return new ArrayList<>(List.of(classes));
    }

    /**
     * Проверяет наличие у класса Аннотации @Run.toRun() == true;<p>
     * При выполнении условия создает объект такого класса и передает в Лист объектов;
     * @param cls элемент Листа классов переданных от {@code invokeMethodsOf(...) };
     */
    private static void objMaker(Class<?> cls) {

        if (cls.isAnnotationPresent(Run.class) && cls.getAnnotation(Run.class).toRun()) {
            try {
                @SuppressWarnings("deprecation")
                Object newObj = Class.forName(cls.getName()).newInstance();
                objectList.add(newObj);
            } catch (IllegalAccessException | ClassNotFoundException | InstantiationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Проверяет методы объекта на наличие Аннотации {@code @Invoke.toInvoke() == true};<p>
     * При выполнении условия структурирует в Листе с параметром {@code <Method>},
     * сортирует по {@code @Invoke.orderNum()} и вызывает данные методы;<p>
     * Если два метода в одном классе помечены {@code @Invoke} с дефолтным значением 0,
     * то они будут вызваны в том порядке, в котором были прописаны в самом классе.
     * @param object элемент Листа объектов переданных от {@code objMaker()};
     * @throws IllegalAccessException
     *         Когда нет доступа к методу (например модификатор метода - private)
     * @throws InvocationTargetException
     *         Исключение, которое упаковывает исключение, созданное вызванным методом или конструктором.
     */
    private static void invoker(Object object){

        List<Method> methodList = new ArrayList<>();
        Method[] methods = object.getClass().getDeclaredMethods();

        Arrays.stream(methods).toList().stream()
                .filter(method -> method.isAnnotationPresent(Invoke.class) && method.getAnnotation(Invoke.class).toInvoke())
                .forEach(methodList::add);

        methodList.stream()
                .sorted(Comparator.comparingInt(method -> method.getAnnotation(Invoke.class).orderNum()))
                .forEach(method -> {
                    try {
                        method.invoke(object);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}

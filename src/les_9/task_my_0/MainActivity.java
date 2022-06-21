package les_9.task_my_0;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * <b> ����������: </b> <p>
 * ������ ������� �� ������� ������� ��������� @Run:<p>
 *      ���� @Run.toRun() == true -> �������� �������� ���� ������� � List(Object);<p>
 *      ���� @Run.toRun() == false -> �������������; <p>
 * <p>
 * ������ ������� � ���������� @Invoke;<p>
 *     ���� @Invoke.toInvoke() == true -> ����� ������� �������� � ������� @Invoke.orderNum(); <p>
 *     ���� @Invoke.toInvoke() == false -> �������������;
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
     * ������������� � {@code List<Class<?>>}, ��������� �� {@code @Run.orderNum} � �������� � {@code objMaker()};
     * @param classes ��������� ������ �������: {@code Class<?>}:
     */
    private static void invokeMethodsOf(Class<?>...classes) {
        classCollector(classes).forEach(MainActivity::objMaker);

        objectList.stream()
                .sorted(Comparator.comparingInt(obj -> obj.getClass().getAnnotation(Run.class).orderNum()))
                .forEach(MainActivity::invoker);
    }


    /**
     * @param classes ��������� �������������� ���������� �������� ���� Class;
     * @return ���� �������;
     */
    private static List<Class<?>> classCollector(Class<?>...classes) {
        return new ArrayList<>(List.of(classes));
    }

    /**
     * ��������� ������� � ������ ��������� @Run.toRun() == true;<p>
     * ��� ���������� ������� ������� ������ ������ ������ � �������� � ���� ��������;
     * @param cls ������� ����� ������� ���������� �� {@code invokeMethodsOf(...) };
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
     * ��������� ������ ������� �� ������� ��������� {@code @Invoke.toInvoke() == true};<p>
     * ��� ���������� ������� ������������� � ����� � ���������� {@code <Method>},
     * ��������� �� {@code @Invoke.orderNum()} � �������� ������ ������;<p>
     * ���� ��� ������ � ����� ������ �������� {@code @Invoke} � ��������� ��������� 0,
     * �� ��� ����� ������� � ��� �������, � ������� ���� ��������� � ����� ������.
     * @param object ������� ����� �������� ���������� �� {@code objMaker()};
     * @throws IllegalAccessException
     *         ����� ��� ������� � ������ (�������� ����������� ������ - private)
     * @throws InvocationTargetException
     *         ����������, ������� ����������� ����������, ��������� ��������� ������� ��� �������������.
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

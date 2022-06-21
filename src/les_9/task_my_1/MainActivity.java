package les_9.task_my_1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MainActivity {

    public static Map<String, Object> mapObj = new HashMap<>();

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        inspectClass(SimpleService.class);
        System.out.println("----------------");
        inspectClass(LazyService.class);
        System.out.println("----------------");

        loadService(SimpleService.class.getName()); //var_1
        loadService("les_9.task_my_1.LazyService"); //var_2

        System.out.println(mapObj.entrySet());
        System.out.println("----------------");

        mapObj.keySet().stream().map(key -> mapObj.get(key)).forEach(MainActivity::methodLoader);
    }

    private static void inspectClass(Class<?> className) {
        if (className.isAnnotationPresent(Service.class)) {
            Service ann = className.getAnnotation(Service.class);
            System.out.println(ann.name());

            Method[] met = className.getDeclaredMethods();
            for (Method m : met) {
                if (m.isAnnotationPresent(Init.class)) {
                    System.out.println(m);
                } else {
                    System.out.println("Not found Annotation @Init");
                }
            }
        }
    }

    private static String getAnnotFor(Class<?> className) {
        if (className.isAnnotationPresent(Service.class)) {
            return className.getAnnotation(Service.class).name();
        } else {
            return null;
        }
    }

    static void loadService (String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName(className);
        if (clazz.isAnnotationPresent(Service.class)) {
            @SuppressWarnings("deprecation")
            Object serviceObj = clazz.newInstance();
            mapObj.put(getAnnotFor(clazz), serviceObj);
        }
    }

    static void methodLoader(Object object) {
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Init.class)) {
                try {
                    method.invoke(object);
                } catch (Exception e) {
                    Init ann = method.getAnnotation(Init.class);
                    if (ann.suppressException()) {
                        System.err.println(e.getMessage());
                    } else {
                        throw new RuntimeException("Runtime error...");
                    }
                }
            }
        }
    }
}
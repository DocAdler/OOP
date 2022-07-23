/**
 * Створити довільний клас , описати його. Створити в мейн його екземпляр,
 * 1. дослідити всю інформацію про нього :
 * 2. отримати всі методи (private в тому числі);
 * 3. отримати поля класу (private в тому числі);
 * 4. отримати всі конструктори;
 * 5. створити екземпляр класу з двох різних конструкторів;
 * 6. викликати 2 методи (один - з параметрами, другий - без параметрів).
 */

package checking_old.les_11.present_16.task_1;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainActivity {

    private static Field[] fields;
    private static Constructor<?>[] constructors;
    private static Method[] methods;
    private static final List<Object> objects = new ArrayList<>();

    public static void main(String[] args) throws ClassNotFoundException,
            InvocationTargetException, InstantiationException,IllegalAccessException {

        User user = new User("Tom", "tom1993@gmail.com", 380934306124L);

        //1-4
        classAnalyzer(user.getClass());
        System.out.println(Arrays.toString(fields));
        System.out.println(Arrays.toString(constructors));
        System.out.println(Arrays.toString(methods));

        //5
        objMaker(new Object[]{"Mike", "132@gmail.com", 38456054686L}, 4);
        objMaker(new Object[]{}, 0);
        objMaker(new Object[]{"Sam"}, 1);
        objMaker(new Object[]{"Tom", 38456054686L}, 2);
        objMaker(new Object[]{"Andrew", "132@gmail.com"}, 3);

        objects.forEach(System.out::println);

        //6
        methodInvoker(objects.get(0), new Object[] {"Well done"}, 7);
        methodInvoker(objects.get(2), new Object[] {}, 5);
    }

    //1
    private static void classAnalyzer(Class<?> cls) {
        //3
        fields = Arrays.stream(cls.getDeclaredFields()).sorted(Comparator.comparing(Field::getName)).toArray(Field[]::new);
        //4
        constructors = Arrays.stream(cls.getDeclaredConstructors()).sorted(Comparator.comparing(Constructor::getParameterCount)).toArray(Constructor[]::new);
        //2
        methods = Arrays.stream(cls.getDeclaredMethods()).sorted(Comparator.comparing(Method::getName).thenComparing(Method::getParameterCount)).toArray(Method[]::new);
    }

    //5
    private static void objMaker(Object[] args, Integer constNumb) throws InstantiationException, IllegalAccessException, InvocationTargetException {

        boolean isPublic = Modifier.isPublic(constructors[constNumb].getModifiers());

        if (isPublic) {

            Object newObj = constructors[constNumb].newInstance(args);
            objects.add(newObj);
        } else {
            System.out.println("Constructor #" + constNumb +" has not Public Modifier");
        }
    }

    //6
    private static void methodInvoker(Object obj, Object[] args, Integer numMethod) throws InvocationTargetException, IllegalAccessException {
        boolean isPublic = Modifier.isPublic(methods[numMethod].getModifiers());
        int paramCount = methods[numMethod].getParameterCount();
        Class<?>[] params = methods[numMethod].getParameterTypes();


        if (isPublic) {
            if (paramCount == args.length) {
                Class<?>[] argsParam = Arrays.stream(args).map(Object::getClass).sorted(Comparator.comparing(Class::getName)).toArray(Class[]::new);
                if (Arrays.equals(params, argsParam)) {
                    methods[numMethod].invoke(obj, args);
                } else {
                    System.out.println("Expected parameters: " + Arrays.toString(params));
                }
            } else {
                System.out.println("In Method #" + numMethod +" expected " + paramCount + " parameters. " + args.length + " received.");
            }
        } else {
            System.out.println("Method #" + numMethod +" has not Public Modifier");
        }
    }
}
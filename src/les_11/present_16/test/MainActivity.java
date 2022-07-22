package les_11.present_16.test;

import java.lang.reflect.*;

public class MainActivity {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName(args[0]);
        Constructor[] cons = c.getConstructors( );
        printList("Constructors", cons);

        Method[] meths = c.getMethods( );
        printList("Methods", meths);

        Field[] fields = c.getFields();
        printList("Fields", fields);

    }

    static void printList(String s, Object[] o) {
        System.out.println("*** " + s + " ***");

        for (int i = 0; i < o.length; i++){
            System.out.println(o[i].toString( ));
        }
    }
}

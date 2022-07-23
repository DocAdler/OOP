package checking.les_2.present6.task2;

import checking.les_2.present6.task2.second.MyCalculator;

public class MainActivity {
    public static void main(String[] args) {

        MyCalculator myCalculator = new MyCalculator();

        System.out.println(myCalculator.plus(2, 5));
        System.out.println(myCalculator.minus(10, 4));
        System.out.println(myCalculator.multiply(6,9));
        System.out.println(myCalculator.devide(7, 3));
    }
}

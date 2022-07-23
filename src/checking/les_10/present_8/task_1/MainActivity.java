/*
Зробити свій Enum, в main методі вивести всі значення цього enum та їх порядкові номери.
 */

package checking.les_10.present_8.task_1;

import java.util.Arrays;

public class MainActivity {
    public static void main(String[] args) {

        Arrays.stream(Numbers.values()).forEach(val -> System.out.println(val.name() + " " + val.ordinal() + ";"));
    }

    private enum Numbers {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN
    }
}


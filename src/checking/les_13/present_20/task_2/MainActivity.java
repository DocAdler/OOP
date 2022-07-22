/*
1. Створити потік. Створити клас MyThread наслідувати його від класу Thread.
Перевизначити метод run(), так щоб можна було вивести введену з консолі кількість чисел Фібоначі.
Тобто ми вводимо з консолі скільки ми хочемо бачити чисел Фібоначі і ми їх виводимо з затримкою в 1 секунду.

2. Створити потік. Створити клас RunnableThread імплементувати його від інтерфейсу Runnable.
Метод run() перевизначити таким чином, щоб числа Фібоначі виводились в зворотньому порядку.
Тобто Спершу ввели через Scanner скільки ми хочемо бачити чисел Фібоначі,
потім з затримкою в 1 секунду вивести їх від останнього до першого значення.

Вигляд на консолі :
-Введіть скільки чисел Фібоначі Ви хочете бачити?
- 5
звичайний порядок : 1, 1, 2, 3, 5
зворотній порядок : 5, 3, 2, 1, 1
 */
package checking.les_13.present_20.task_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainActivity {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Input....");

        int count = sc.nextInt();
        MyThread mt = new MyThread(count);
        Thread th = new Thread(new RunnableThread(count));
        mt.start();
        th.start();
    }

    //1
    private static class MyThread extends Thread{

        private final int num;

        private MyThread(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            fib(num).forEach(elem -> {
                System.out.println("D:" + elem + " ");
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        List<Integer> fib(int num) {
            List<Integer> result = new ArrayList<>();
            int n1 = 1;
            int n2 = 1;
            int sum;

            for (int i = 1; i <= num; i++, n1 = n2, n2 = sum) {
                if (i == 1 || i == 2) {
                    sum = 1;
                } else {
                    sum = n1 + n2;
                }
                result.add(sum);
            }
            return result;
        }
    }

    //2
    private record RunnableThread(int num) implements Runnable {

        @Override
            public void run() {
                new ArrayList<Integer>(Arrays.asList(fibRev(num))).forEach(elem -> {
                    System.out.println("R:" + elem + " ");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }

            Integer[] fibRev(int num) {
                Integer[] result = new Integer[num];
                int n1 = 0;
                int n2 = 1;
                int sum;

                for (int i = num - 1; i >= 0; i--, n1 = n2, n2 = sum) {
                    if (i == num - 1 || i == num - 2) {
                        sum = 1;
                    } else {
                        sum = n1 + n2;
                    }
                    result[i] = sum;
                }
                return result;
            }
        }

}

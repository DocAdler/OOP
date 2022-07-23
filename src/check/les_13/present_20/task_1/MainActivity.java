/*
Створити потік (унаслідуватись від Thread) DirectThread, реалізувати у ньому метод run(),
    який буде виводити масив(або ліст) елементів, які попередньо ввів користувач з перервою 1.5 секунди.

Створити потік (унаслідуватись від Runnable) SortedRunnable, реалізувати у ньому метод run(),
    який буде виводити масив(або ліст) ПОСОРТОВАНИХ елементів, які попередньо ввів користувач з перервою 1.5 секунди.

Рекомендація : для опрацювання інформації від користувача (масиву) рекомендую зробити інший клас Service,
    у якому буде функціонал для зчитування масиву з консолі. І він буде повертати масив(або ліст)

 */

package check.les_13.present_20.task_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.lang.Thread.sleep;

public class MainActivity {
    public static void main(String[] args) throws IOException, InterruptedException {


        System.out.println("Input....");
        ConsoleReader cr = new ConsoleReader();
        String[] strArr = cr.read();
        System.out.println(Arrays.toString(strArr));

        DirectThread dt = new DirectThread(Arrays.asList(strArr));
        SortedRunnable sr = new SortedRunnable(Arrays.asList(strArr.clone()));
        Thread sortedThread = new Thread(sr);
        dt.start();
        sortedThread.start();

        sortedThread.join();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }).start();
    }

    private static class DirectThread extends Thread {

        private final List<String> elements;

        private DirectThread(List<String> elements) {
            this.elements = elements;
        }

        @Override
        public void run() {
            elements.forEach(elem -> {
                System.out.println("DirectThread element: " + elem);
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private record SortedRunnable(List<String> elements) implements Runnable {

        @Override
            public void run() {
                elements.sort(Comparator.naturalOrder());
                elements.forEach(elem -> {
                    System.out.println("SortedRunnable element: " + elem);
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }

    private static class ConsoleReader {

        String[] read() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String elements = br.readLine();
            return elements.split(",");
        }
    }
}

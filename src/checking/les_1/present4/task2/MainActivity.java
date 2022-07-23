package checking.les_1.present4.task2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity {
    public static void main(String[] args) {
        Robot rb = new Robot();
        rb.work();

        Robot rb1 = new CoffeRobot();
        rb1.work();

        Robot rb2 = new RobotDancer();
        rb2.work();

        Robot rb3 = new RobotCoocker();
        rb3.work();

        System.out.println();

        List<Robot> list = new ArrayList<>();
        list.add(rb);
        list.add(rb1);
        list.add(rb2);
        list.add(rb3);

        for (Robot robot : list) {
            robot.work();
        }
    }
}

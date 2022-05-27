package checking.les_2.present5.task1;

import java.util.ArrayList;
import java.util.List;

public class MainActivity {
    public static void main(String[] args) {

        List<Flower> list = new ArrayList<>();

        Flower1 flower1 = new Flower1("white", 10);
        Flower2 flower2 = new Flower2("red", 15);
        Flower3 flower3 = new Flower3("yellow", 5);

        list.add(flower1);
        list.add(flower2);
        list.add(flower3);

        int sum = 0;
        for (Flower flower : list){
            sum += flower.getPrice();
        }

        System.out.println(sum);
    }
}

package checking.les_2.present5.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomWeapon {

    Weapon knife = new Weapon("Нож", 100);
    Weapon axe = new Weapon("Топор", 120);
    Weapon hand = new Weapon("Кулак", 50);
    Weapon gun = new Weapon("Пистолет", 150);

    List<Weapon> weaponList = new ArrayList<>();

    public Weapon randomWeapon() {
        weaponList.add(knife);
        weaponList.add(axe);
        weaponList.add(hand);
        weaponList.add(gun);

        return weaponList.get(new Random().nextInt(weaponList.size()));
    }
}

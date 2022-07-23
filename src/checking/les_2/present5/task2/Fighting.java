package checking.les_2.present5.task2;

import java.util.List;
import java.util.Random;

public class Fighting {

    public static void toFight(Warrior... warrior) {

        List<Warrior> warriors = new java.util.ArrayList<>(List.of(warrior));

        startFight(warriors);
    }

    private static void startFight(List<Warrior> warriors){

        int choice1 = new Random().nextInt(warriors.size());
        int choice2 = new Random().nextInt(warriors.size());

        if (choice1 != choice2) {

            warriors.get(choice2).setHp(warriors.get(choice2).getHp() - warriors.get(choice1).getWeaponDamage());

            System.out.println(warriors.get(choice1).getName() + " используя " + warriors.get(choice1).getWeaponName()
                    + " нанес удар " + warriors.get(choice2).getName());
            System.out.println("Нанесенный урон: " + warriors.get(choice1).getWeaponDamage());
            System.out.println("Остаток НР " + warriors.get(choice2).getName() + " : " + warriors.get(choice2).getHp() + "\n");

            if (warriors.get(choice2).getHp() <= 0) {
                System.out.println(warriors.get(choice2).getName() + " мёртв.");
                warriors.remove(warriors.get(choice2));

                System.out.println("Осталось воинов : " + warriors.size() + "\n");

                if (warriors.size() == 1) {
                    System.out.println(warriors.get(0).getName() + " is win!");

                } else {
                    startFight(warriors);
                }

            } else {
                startFight(warriors);
            }

        } else {
            startFight(warriors);
        }
    }
}

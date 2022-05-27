package les_2.present5.task2;

public class MainActivity {
    public static void main(String[] args) {

        Weapon knife = new Weapon("Нож", 100);
        Weapon axe = new Weapon("Топор", 120);
        Weapon hand = new Weapon("Кулак", 50);

        Warrior1 warrior1 = new Warrior1("Воин 1", 200, knife);
        Warrior2 warrior2 = new Warrior2("Воин 2", 220, hand);
        Warrior3 warrior3 = new Warrior3("Воин 3", 250, axe);

        System.out.println(warrior1);
        System.out.println(warrior2);
        System.out.println(warrior3);

        System.out.println("\n" + "Раунд №1" + "\n");

        Fighting.toFight(warrior1, warrior2, warrior3);

        warrior1.setWeapon(new RandomWeapon().randomWeapon());
        warrior1.setHp(200);
        warrior2.setWeapon(new RandomWeapon().randomWeapon());
        warrior2.setHp(220);
        warrior3.setWeapon(new RandomWeapon().randomWeapon());
        warrior3.setHp(250);

        System.out.println("------------------------------------");

        System.out.println(warrior1);
        System.out.println(warrior2);
        System.out.println(warrior3);

        System.out.println("\n" + "Раунд №2" + "\n");

        Fighting.toFight(warrior1, warrior2, warrior3);
    }
}

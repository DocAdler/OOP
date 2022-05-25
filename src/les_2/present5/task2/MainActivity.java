package les_2.present5.task2;

public class MainActivity {
    public static void main(String[] args) {

        Weapon knife = new Weapon("Нож", 100);
        Weapon axe = new Weapon("Топор", 150);
        Weapon hand = new Weapon("Кулак", 50);

        Warrior1 warrior1 = new Warrior1("Воин 1", 200, knife);
        Warrior2 warrior2 = new Warrior2("Воин 2", 220, hand);
        Warrior3 warrior3 = new Warrior3("Воин 3", 250, axe);


        Fighting.toFight(warrior1, warrior2, warrior3);
    }
}

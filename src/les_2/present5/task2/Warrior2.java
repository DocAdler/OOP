package les_2.present5.task2;

public class Warrior2 extends Warrior{

    Weapon weapon;

    public Warrior2(String name, Integer hp, Weapon weapon) {
        super(name, hp, weapon);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}

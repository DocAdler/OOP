package les_2.present5.task2;

public class Warrior1 extends Warrior {

    Weapon weapon;

    public Warrior1(String name, Integer hp, Weapon weapon) {
        super(name, hp, weapon);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}

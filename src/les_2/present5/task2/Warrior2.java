package les_2.present5.task2;

public class Warrior2 extends Warrior {

    Weapon weapon;

    public Warrior2(String name, Integer hp, Weapon weapon) {
        super(name, hp);
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Integer getWeaponDamage() {
        return weapon.getDamage();
    }

    public String getWeaponName(){
        return weapon.getName();
    }

    @Override
    public String toString() {
        return super.getName() + ": " +
                "HP = " + super.getHp() +
                ", Оружие " + weapon;
    }
}

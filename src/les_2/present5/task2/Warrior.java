package les_2.present5.task2;

public class Warrior {
    private String name;
    private Integer hp;
    private final Weapon weapon;

    public Warrior(String name, Integer hp, Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getWeaponDamage() {
        return weapon.getDamage();
    }

    public String getWeaponName(){
        return weapon.getName();
    }

}

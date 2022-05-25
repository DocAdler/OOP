package les_2.present5.task2;

public class Weapon {

    String name;
    Integer damage;

    public Weapon(String name, Integer damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return name + " (урон = " + damage + ")";
    }
}

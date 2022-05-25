package les_1.present4.task4;

public class Animal {

    private String name;
    private Double speed;
    private Integer age;

    public Animal(String name, Double speed, Integer age) {
        this.name = name;
        this.speed = speed;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return  "Назва тварини = " + name +
                ", Швидкість тварини = " + speed + " км/год" +
                ", Вік тварини = " + age + " років;";
    }
}

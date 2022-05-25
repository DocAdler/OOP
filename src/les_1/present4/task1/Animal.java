package les_1.present4.task1;

public class Animal {

    private String name;
    private Integer age;
    private String color;

    public Animal() {
    }

    public Animal(String name, Integer age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public void eat() {
        System.out.println("I`m eating");
    }

    public void eat(String food) {
        System.out.printf("I`m eating %s" + food + "\n");
    }

    public void sleep() {
        System.out.println("I`m sleeping");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

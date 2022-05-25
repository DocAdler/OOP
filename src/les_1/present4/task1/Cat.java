package les_1.present4.task1;

public class Cat extends Animal {

    public Cat() {
    }

    public Cat(String name, Integer age, String color) {
        super(name, age, color);
    }

    @Override
    public void eat() {
        if (getName() != null) {
            System.out.printf("%s is eating" + "\n", getName());
        } else {
            System.out.println("Some cat is eating");
        }
    }

    @Override
    public void eat(String food) {
        if (getName() != null) {
            System.out.printf("%s is eating %s" + "\n", getName(), food);
        } else {
            System.out.printf("Some cat is eating %s" + "\n", food);
        }
    }

    @Override
    public void sleep() {
        if (getName() != null) {
            System.out.printf("%s is sleeping" + "\n", getName() );
        } else {
            System.out.println("Some cat is sleeping");
        }
    }

}

package les_2.task1;

public class Dog extends Animal {

    public Dog() {
    }

    public Dog(String name, Integer age, String color) {
        super(name, age, color);
    }

    @Override
    public void eat() {
        if (getName() != null) {
            System.out.printf("%s is eating" + "\n", getName());
        } else {
            System.out.println("Some dog is eating");
        }
    }

    @Override
    public void eat(String food) {
        if (getName() != null) {
            System.out.printf("%s is eating %s" + "\n", getName(), food);
        } else {
            System.out.printf("Some dog is eating %s" + "\n", food);
        }
    }

    @Override
    public void sleep() {
        if (getName() != null) {
            System.out.printf("%s is sleeping" + "\n", getName() );
        } else {
            System.out.println("Some dog is sleeping");
        }
    }
}

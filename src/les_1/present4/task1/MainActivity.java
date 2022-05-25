package les_1.present4.task1;

public class MainActivity {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.sleep();
        System.out.println();

        Dog dog1 = new Dog("Woolf", 10, "black" );
        dog1.eat();
        dog1.sleep();
        dog1.eat("Meat");
        System.out.println();

        Cat cat = new Cat();
        cat.eat();
        cat.sleep();
        System.out.println();

        Cat cat1 = new Cat("Barsik", 5,"grey");
        cat1.eat();
        cat1.sleep();
        cat.eat("Fish");
    }
}

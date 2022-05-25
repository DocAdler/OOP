package les_1.present4.task4;

public class MainActivity {
    public static void main(String[] args) {
        Animal animal = new Animal("Леопард", 20.0, 7);

        System.out.println(animal);

        animal.setName("Бик");
        animal.setSpeed(2.0);
        animal.setAge(14);

        System.out.println(animal);
    }
}

package checking.les_1.present3.task2;

public class MainActivity {
    public static void main(String[] args) {

        Rectangle rect1 = new Rectangle();
        System.out.println("Площадь по умолчанию: " + rect1.getSquare());
        System.out.println("Периметр по умолчанию: " + rect1.getPerimeter());


        Rectangle rect2 = new Rectangle(10, 20);
        System.out.println("Площадь с заданными сторонами: " + rect2.getSquare());
        System.out.println("Периметр с заданными сторонами: " + rect2.getPerimeter());
    }
}

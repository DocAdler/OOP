package les_1.task3;

public class Circle {

    private Double radius;
    private Double diameter;
    final double pi = 3.1415;

    public Circle() {
    }

    public double getSquare(double diameter) {
        return pi * Math.pow(diameter/2 , 2);
    }

    public double getLength(double radius){
        return  2 * pi * radius;
    }
}

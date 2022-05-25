package les_2.present6.task2.second;

public class MyCalculator implements les_2.present6.task2.first.Numerable{


    @Override
    public double devide(int a, int b) {
        return (double) a / (double) b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }

    @Override
    public double multiply(int a, int b) {
        return a * b;
    }

    @Override
    public int plus(int a, int b) {
        return a + b;
    }
}

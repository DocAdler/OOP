package checking.les_1.present4.task3;

public class MainActivity {
    public static void main(String[] args) {

        CarBody carBody = new CarBody("black", "sedan");
        SteeringWheel steeringWheel = new SteeringWheel(50);
        Wheels wheels = new Wheels(95, "snow");

        Car car1 = new Car(5,"Audi", carBody, steeringWheel, wheels);

        System.out.println(car1);

        carBody.setColor("yellow");
        steeringWheel.setDiameter(55);
        wheels.setType("summer");

        System.out.println(car1);

    }
}

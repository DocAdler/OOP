package les_2.task3;

public class Car {

    Integer age;
    String model;
    CarBody carBody;
    SteeringWheel steeringWheel;
    Wheels wheels;

    public Car(Integer age, String model, CarBody carBody, SteeringWheel steeringWheel, Wheels wheels) {
        this.age = age;
        this.model = model;
        this.carBody = carBody;
        this.steeringWheel = steeringWheel;
        this.wheels = wheels;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public CarBody getCarBody() {
        return carBody;
    }

    public void setCarBody(CarBody carBody) {
        this.carBody = carBody;
    }

    public SteeringWheel getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(SteeringWheel steeringWheel) {
        this.steeringWheel = steeringWheel;
    }

    public Wheels getWheels() {
        return wheels;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "Car{" +
                "age=" + age +
                ", model='" + model + '\'' +
                ", carBody=" + carBody +
                ", steeringWheel=" + steeringWheel +
                ", wheels=" + wheels +
                '}';
    }
}

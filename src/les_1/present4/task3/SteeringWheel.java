package les_1.present4.task3;

public class SteeringWheel {

    private Integer diameter;

    public SteeringWheel(Integer diameter) {
        this.diameter = diameter;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "Wheels{" +
                "diameter=" + diameter +
                '}';
    }
}

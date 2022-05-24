package les_2.task3;

public class Wheels {

    private Integer diameter;
    private String type;

    public Wheels(Integer diameter, String type) {
        this.diameter = diameter;
        this.type = type;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SteeringWheel{" +
                "diameter=" + diameter +
                ", type='" + type + '\'' +
                '}';
    }
}

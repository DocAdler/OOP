package les_1.task2;

public class Rectangle {

    private Integer length;
    private Integer width;

    public Rectangle() {
        this.length = 10;
        this.length = 7;
    }

    public Rectangle(Integer length, Integer width) {
        this.length = length;
        this.width = width;
    }

    public double getSquare(){
        return this.length * this.width;
    }

    public double getPerimeter(){
        return (this.length + this.width * 2);
    }
}

package TPS.TP1.ej8;

public class Rectangle extends Figure{
    Point topLeft;
    Point bottomRight;

    Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public double base() {
        return Math.abs(this.topLeft.getX() - this.bottomRight.getX());
    }

    public double height() {
        return Math.abs(this.topLeft.getY() - this.bottomRight.getY());
    }

    @Override
    public double area(){
        return Math.abs(this.topLeft.getX() - this.bottomRight.getX()) * Math.abs(this.topLeft.getY() - this.bottomRight.getY());
    }

    @Override
    public double perimeter() {
        return 2 * Math.abs(this.topLeft.getX() - this.bottomRight.getX()) + 2 * Math.abs(this.topLeft.getY() - this.bottomRight.getY());
    }
}
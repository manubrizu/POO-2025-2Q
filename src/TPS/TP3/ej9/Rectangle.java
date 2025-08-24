package TPS.TP3.ej9;

public class Rectangle extends Figure {
    private final Point topLeft, bottomRight;

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
        return base() * height();
    }

    @Override
    public double perimeter() {
        return 2 * base() + 2 * height();
    }

    @Override
    public String toString() {
        return "Rectángulo [ %s , %s ]".formatted(topLeft, bottomRight);
    }
}
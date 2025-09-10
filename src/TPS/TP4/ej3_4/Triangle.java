package TPS.TP4.ej3_4;

public class Triangle extends Figure {
    protected final Point firstPoint, secondPoint, thirdPoint;

    Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }

    @Override
    public double area() {
        return Math.abs((firstPoint.getX() * (secondPoint.getY() - thirdPoint.getY()) +
                secondPoint.getX() * (thirdPoint.getY() - firstPoint.getY()) +
                thirdPoint.getX() * (firstPoint.getY() - secondPoint.getY())) / 2.0);
    }

    @Override
    public double perimeter() {
        return firstSide() + secondSide() + thirdSide();
    }

    private double firstSide(){
        return this.firstPoint.distanceTo(this.secondPoint);
    }

    private double secondSide(){
        return this.secondPoint.distanceTo(this.thirdPoint);
    }

    private double thirdSide(){
        return this.thirdPoint.distanceTo(this.firstPoint);
    }

    @Override
    public String toString() {
        return "Triángulo [ %s , %s , %s ]".formatted(firstPoint, secondPoint, thirdPoint);
    }
}

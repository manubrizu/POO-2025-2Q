package TP1.ej8;

public class Triangle extends Figure {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;

    Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }

    @Override
    public double area() {
        return Math.abs(this.firstPoint.getX() - this.secondPoint.getX()) * Math.abs(this.firstPoint.getY() - this.thirdPoint.getY()) / 2;
    }

    @Override
    public double perimeter() {
        return this.firstPoint.getDistance(this.secondPoint) + this.secondPoint.getDistance(this.thirdPoint) +  this.thirdPoint.getDistance(this.firstPoint);
    }
}

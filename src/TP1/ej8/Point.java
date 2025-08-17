package TP1.ej8;

public class Point {
    private double coordX, coordY;

    public Point(double x, double y) {
        this.coordX = x;
        this.coordY = y;
    }

    public double getX() {
        return this.coordX;
    }

    public double getY() {
        return this.coordY;
    }

    public double getDistance(Point p) {
        return Math.sqrt(Math.pow(this.coordX - p.getX(), 2) + Math.pow(this.coordY - p.getY(), 2));
    }
}

package TPS.TP3.ej9;

import java.util.Objects;

public class Point {
    private final double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceTo(Point p) {
        return Math.sqrt(Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2));
    }

    @Override
    public String toString() {
        return "{%.2f, %.2f}".formatted(x, y);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Point &&
                ((Point) o).getX() == x &&
                ((Point) o).getY() == y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}


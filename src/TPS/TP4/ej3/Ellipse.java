package TPS.TP4.ej3;

public class Ellipse extends Figure {
    protected final Point centerPoint;
    protected final double sMayorAxis, sMenorAxis;

    Ellipse(Point centerPoint, double sMayorAxis, double sMenorAxis) {
        this.centerPoint = centerPoint;
        this.sMayorAxis = sMayorAxis;
        this.sMenorAxis = sMenorAxis;
    }

    @Override
    public double area() {
        return Math.PI / 4 * sMayorAxis * sMenorAxis;
    }


    @Override
    public double perimeter() {
        return Math.PI / 2 * (sMayorAxis + sMenorAxis);
    }

    @Override
    public String toString() {
        return "Elipse [Centro: %s, DMayor: %.2f, DMenor: %.2f]".formatted(centerPoint, sMayorAxis, sMenorAxis);
    }

}

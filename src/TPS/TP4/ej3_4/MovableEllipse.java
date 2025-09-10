package TPS.TP4.ej3_4;

public class MovableEllipse extends Ellipse implements MovableFigure {
    public MovableEllipse(MovablePoint centerPoint, double sMayorAxis, double
            sMinorAxis) {
        super(centerPoint, sMayorAxis, sMinorAxis);
    }

    @Override
    public MovablePoint[] getPoints() {
        return new MovablePoint[]{(MovablePoint)centerPoint};
    }
}

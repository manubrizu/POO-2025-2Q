package TPS.TP4.ej3_4;

public interface MovableFigure extends Movable {
    MovablePoint[] getPoints();
    @Override
    default void moveNorth(double delta) {
        for(MovablePoint movablePoint : getPoints()) {
            movablePoint.moveNorth(delta);
        }
    }
    @Override
    default void moveSouth(double delta) {
        for(MovablePoint movablePoint : getPoints()) {
            movablePoint.moveSouth(delta);
        }
    }
    @Override
    default void moveWest(double delta) {
        for(MovablePoint movablePoint : getPoints()) {
            movablePoint.moveWest(delta);
        }
    }
    @Override
    default void moveEast(double delta) {
        for(MovablePoint movablePoint : getPoints()) {
            movablePoint.moveEast(delta);
        }
    }
    @Override
    default void moveNorthEast(double deltaX, double deltaY) {
        for(MovablePoint movablePoint : getPoints()) {
            movablePoint.moveNorthEast(deltaX, deltaY);
        }
    }
    @Override
    default void moveNorthWest(double deltaX, double deltaY) {
        for(MovablePoint movablePoint : getPoints()) {
            movablePoint.moveNorthWest(deltaX, deltaY);
        }
    }
    @Override
    default void moveSouthEast(double deltaX, double deltaY) {
        for(MovablePoint movablePoint : getPoints()) {
            movablePoint.moveSouthEast(deltaX, deltaY);
        }
    }
    @Override
    default void moveSouthWest(double deltaX, double deltaY) {
        for(MovablePoint movablePoint : getPoints()) {
            movablePoint.moveSouthWest(deltaX, deltaY);
        }
    }
}
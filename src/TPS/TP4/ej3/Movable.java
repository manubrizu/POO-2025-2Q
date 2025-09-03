package TPS.TP4.ej3;

public interface Movable {
    void moveNorth(double delta);
    void moveSouth(double delta);
    void moveWest(double delta);
    void moveEast(double delta);
    void moveNorthEast(double deltaX, double deltaY);
    void moveNorthWest(double deltaX, double deltaY);
    void moveSouthEast(double deltaX, double deltaY);
    void moveSouthWest(double deltaX, double deltaY);
}

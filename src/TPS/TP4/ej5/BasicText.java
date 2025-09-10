package TPS.TP4.ej5;

public abstract class BasicText implements HTMLText {
    @Override
    public String toString() {
        return source();
    }
}

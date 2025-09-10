package TPS.TP4.ej8;

@FunctionalInterface // Si bien no es necesario para su funcionamiento, es una buena práctica indicar que la interfaz es funcional
public interface IntervalCondition {
    boolean satisfies(double value);
}


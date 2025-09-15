package TPS.TP5.ej13;

@FunctionalInterface // Si bien no es necesario para su funcionamiento, es una buena práctica indicar que la interfaz es funcional
public interface IntervalCondition {
    boolean satisfies(double value);
}


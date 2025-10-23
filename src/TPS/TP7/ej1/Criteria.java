package TPS.TP7.ej1;

// ESTO ES LITERALMENTE UN PREDICATE CASERO

@FunctionalInterface
public interface Criteria<T> {
    boolean satisfies(T obj);
}
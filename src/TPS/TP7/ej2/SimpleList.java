package TPS.TP7.ej2;

import java.util.List;

public interface SimpleList<E> extends List<E> {
    <T> T reduce(T initialValue, Reducer<E, T> reducer);
}

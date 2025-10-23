package TPS.TP7.ej2;

import java.util.ArrayList;

public class SimpleArrayList<E> extends ArrayList<E> implements SimpleList<E> {
    @Override
    public <T> T reduce(T initialValue, Reducer<E, T> reducer) {
        T toReturn = initialValue;
        for (E elem : this){
            toReturn = reducer.reduce(toReturn, elem);
        }
        return toReturn;
    }
}

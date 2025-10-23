package TPS.TP7.ej1;

import java.util.ArrayList;

public class ArrayFilterList<T> extends ArrayList<T> implements FilterList<T>{
    public FilterList<T> filter(Criteria<T> criteria) {
        FilterList<T> result = new ArrayFilterList<>();
        for(T elem : this) {                // es para poder iterar sobre los elementos de la lista
            if (criteria.satisfies(elem)) {
                result.add(elem);
            }
        }
        return result;
    }
}

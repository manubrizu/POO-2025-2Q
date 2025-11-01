package PARCIALES.P2.repaso.ej1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SimpleArrayList<E> extends ArrayList<E> implements SimpleList<E> {

    @Override
    public <K> Map<K, E> toMap(Mapper<E, K> mapper) {
        Map<K, E> toReturn = new HashMap<>();
        for(E elem : this){
            toReturn.put(mapper.map(elem), elem);
        }
        return toReturn;
    }
}

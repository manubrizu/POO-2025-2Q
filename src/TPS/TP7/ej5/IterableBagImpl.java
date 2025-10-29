package TPS.TP7.ej5;

import java.util.*;

public class IterableBagImpl<E extends Comparable<? super E>> extends BagImpl<E> implements IterableBag<E>{

    IterableBagImpl(){
        map = new TreeMap<>(Comparator.reverseOrder());     // Orden Descendente
    }

    @Override
    public Iterable<E> elements() {
        List<E> toReturn = new ArrayList<>();
        for(Map.Entry<E, Integer> entry : map.entrySet()){
            for(int i = 0; i < entry.getValue(); i++) {
                toReturn.add(entry.getKey());
            }
        }
        return toReturn;
    }

    @Override
    public Iterable<E> elementsDistinct() {
        return map.keySet();
    }
}

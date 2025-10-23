package TPS.TP6.ej10;

import java.util.*;

public class MultiSortedCollectionImpl<T> implements MultiSortedCollection<T>{
    private Map<Comparator<T>, Set<T>> map = new HashMap<>();
    private Set<T> data = new HashSet<>();  // es para tener una colección de referencia y utilizarla en caso de que se
                                            // agreguen nuevos comparadores dsp de haber agregado elementos

    @Override
    public void add(T elem) {
        data.add(elem);
        if(map.isEmpty()) {
            throw new IllegalStateException();
        }
        for(Set<T> set : map.values()) {
            set.add(elem);
        }
    }

    @Override
    public void add(Comparator<T> cmp) {
        TreeSet<T> newSet = new TreeSet<>(cmp);
        newSet.addAll(data);
        map.put(cmp, newSet);
    }

    @Override
    public void remove(T elem) {
        data.remove(elem);
        for(Set<T> set : map.values()) {
            set.remove(elem);
        }
    }

    @Override
    public Iterable<T> iterable(Comparator<T> cmp) {
        if(!map.containsKey(cmp)) {
            throw new IllegalStateException();
        }
        return map.get(cmp);
    }
}

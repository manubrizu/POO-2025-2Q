package TPS.TP7.ej7;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SortedMapImpl<K extends Comparable<? super K>,V> extends TreeMap<K,V> implements SortedMap<K,V>{

    private Map.Entry<K, V> getFirstEntry(){
        return iterator().next();
    }

    @Override
    public K firstKey(){
        return getFirstEntry().getKey();
     // return super.firstKey();
    }

    @Override
    public V firstValue() {
        return getFirstEntry().getValue();
     // return get(firstKey());
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return entrySet().iterator();
    }
}

package PARCIALES.P2.repaso.ej3;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class FilteredKeyMapIterator<K, V> implements Iterator<K> {
    private V current;
    private final Iterator<Map.Entry<K, V>> it;
    private final Predicate<K> pred;

    FilteredKeyMapIterator(Map<K, V> map, Predicate<K> pred){
        this.it = map.entrySet().iterator();
        this.pred = pred;
    }


    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public K next() {
        while (hasNext()){
            Map.Entry<K, V> currentEntry = it.next();
            if (pred.test(currentEntry.getKey())){
                current = currentEntry.getValue();
                return currentEntry.getKey();
            }
        }
        throw new NoSuchElementException();
    }

    public V getValue() {
        if (current == null){
            throw new NoSuchElementException();
        }
        return current;
    }
}

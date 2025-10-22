package TPS.TP6.ej3;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PairCyclicIterator<E> implements Iterator<Pair<E>> {
    private final Iterable<E> collection;
    private Iterator<E> iterator;
    
    PairCyclicIterator(Iterable<E> collection) {
        this.collection = collection;
        this.iterator = collection.iterator();
    }
    
    @Override
    public boolean hasNext() {
        return this.collection.iterator().hasNext();
    }
    
    @Override
    public Pair<E> next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }

        E l, r;
        if(!iterator.hasNext()) {
            iterator = collection.iterator();
        }
        l = iterator.next();

        if(!iterator.hasNext()) {
            iterator = collection.iterator();
        }
        r = iterator.next();
        return new Pair<>(l, r);
    }
}
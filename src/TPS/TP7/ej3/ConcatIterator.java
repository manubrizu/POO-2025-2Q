package TPS.TP7.ej3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ConcatIterator<E> implements Iterator<E> {
    private Iterator<E> currentIterator, nextIterator;

    ConcatIterator(Iterator<E> it1, Iterator<E> it2){
        this.currentIterator = it1;
        this.nextIterator = it2;
    }

    @Override
    public boolean hasNext(){
        if(!currentIterator.hasNext() && currentIterator != nextIterator){
            currentIterator = nextIterator;
        }
        return currentIterator.hasNext();
    }

    @Override
    public E next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return currentIterator.next();
    }
}

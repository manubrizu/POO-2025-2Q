package TPS.TP5.ej15;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CyclicWindowIterator<E> implements Iterator<E[]> {
    private int currentIndex;
    private int rep;
    private final E[] collection;
    private final int windowSize;
    private int currentRep;

    @SuppressWarnings("unchecked")
    public CyclicWindowIterator(E[] collection, int rep) {
        this.collection = collection;
        this.windowSize = 2;
        this.rep = rep;
        this.currentIndex = 0;
        this.currentRep = 0;
    }

    @Override
    public boolean hasNext() {
        return currentRep < rep;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        // Create a new array for the window
        E[] window = (E[]) new Object[windowSize];
        
        // Fill the window with elements from the collection
        for (int i = 0; i < windowSize; i++) {
            window[i] = collection[(currentIndex + i) % collection.length];
        }
        
        // Move to the next position
        currentIndex = (currentIndex + 1) % collection.length;
        
        // If we've completed a full cycle, increment the repetition counter
        if (currentIndex == 0) {
            currentRep++;
        }
        
        return window;
    }
}

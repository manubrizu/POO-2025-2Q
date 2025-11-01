package PARCIALES.P1.P20231C.ej1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.UnaryOperator;

public class CustomIndex<T> implements Iterable<T>{
    private T[] vec;
    int startIdx, endIdx;
    private UnaryOperator<Integer> customIterator;

    CustomIndex(T[] vec, int startIdx, int endIdx, UnaryOperator<Integer> customIterator){
        this.vec = vec;
        this.startIdx = startIdx;
        this.endIdx = endIdx;
        this.customIterator = customIterator;
    }

    public void setNextIndex(UnaryOperator<Integer> customIterator){
        this.customIterator = customIterator;
    }

    @Override
    public Iterator<T> iterator(){
        return new CustomIndexIterator();
    }

    public class CustomIndexIterator implements Iterator<T>{
        private int currentIdx = startIdx;

        @Override
        public boolean hasNext(){
            return currentIdx <= endIdx;
        }

        @Override
        public T next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T toReturn = vec[currentIdx];
            currentIdx = customIterator.apply(currentIdx);
            return toReturn;
        }
    }
}

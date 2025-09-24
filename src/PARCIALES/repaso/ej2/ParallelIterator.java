package PARCIALES.repaso.ej2;

import TPS.TP5.ej1.Pair;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ParallelIterator<T> implements Iterator<ParallelIterator.Pair<T>> {
    private T[] vec1, vec2;
    private int index;

    ParallelIterator(T[] vec1, T[] vec2){
        if(vec1 == null){
            throw new RuntimeException("First collection missing");
        }
        if(vec2 == null){
            throw new RuntimeException("Second collection missing");
        }

        this.vec1 = vec1;
        this.vec2 = vec2;
    }


    @Override
    public boolean hasNext(){
        return index < vec1.length && index < vec2.length;
    }

    @Override
    public Pair<T> next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return new Pair<T>(vec1[index], vec2[index++]);
    }

    public static class Pair<E> {
        private final E left, right;

        Pair(E left, E right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "{%s,%s}".formatted(left, right);
        }
    }
}

package TALLER.taller5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T>{
    private final int BLOCK = 10;
    private T[] array;
    private int index, size;

    @SuppressWarnings("unchecked")
    ArrayList(int size){
        this.array = (T[]) new Object[size];
        this.size = size;
        this.index = 0;
    }

    public ArrayList() {
    }

    private boolean canAdd(){
        return index < size;
    }

    @Override
    public boolean add(T element){
        if(!canAdd()){
            this.array = Arrays.copyOf(this.array, size + BLOCK);
            this.size += BLOCK;
        }
        this.array[index++] = element;
        return false;
    }

    @Override
    public int getIndex(T element){
        for (int i = 0; i < index; i++){
            if (element.equals(this.array[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(int removeIndex){
        if (removeIndex < 0 || removeIndex >= this.index){
            return false;
        }
        for (int i = removeIndex; i < index - 1; i++){
            this.array[i] = this.array[i + 1];
        }
        this.array[--index] = null;
        return true;
    }

    @Override
    public boolean isEmpty(){
        return this.index == 0;
    }

    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T>{
        private int current = 0;

        ArrayListIterator(){

        }

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T elem = array[current];
            current++;
            return elem;
        }
    }

    public Iterator<T> customIterator(Comparator<T> comparator){
        T[] aux = Arrays.copyOf(array, size);
        Arrays.sort(aux, comparator);
        return new ArrayListIterator();
    }
}

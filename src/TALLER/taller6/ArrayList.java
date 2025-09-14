package TALLER.taller6;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private final int BLOCK = 10;
    private T[] array;
    private int index, size;

    @SuppressWarnings("unchecked")
    ArrayList(int size){
        this.array = (T[]) new Object[size];
        this.size = size;
        this.index = 0;
    }

    private boolean canAdd(){
        return index < size;
    }

    @Override
    public void add(T element){
        if(!canAdd()){
            this.array = Arrays.copyOf(this.array, size + BLOCK);
            this.size += BLOCK;
        }
        this.array[index++] = element;
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
}

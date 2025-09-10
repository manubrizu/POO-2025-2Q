package TALLER.taller4;

import java.util.Arrays;

public class ArrayIntegerList implements List<Integer> {
    private final int BLOCK = 10;
    private Integer[] array;
    private int index, size;

    ArrayIntegerList(int size){
        this.array = new Integer[size];
        this.size = size;
        this.index = 0;
    }

    private boolean canAdd(){
        return index < size;
    }

    @Override
    public void add(Integer element){
        if(!canAdd()){
            this.array = Arrays.copyOf(this.array, size + BLOCK);
            this.size += BLOCK;
        }
        this.array[index++] = element;
    }

    @Override
    public int getIndex(Integer element){
        for (int i = 0; i < index; i++){
            if (element != null && element.equals(this.array[i])){
                return i;
            }
            if (element == null && this.array[i] == null){
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

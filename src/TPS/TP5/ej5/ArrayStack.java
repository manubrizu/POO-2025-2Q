package TPS.TP5.ej5;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E>{
    private E[] elems;
    private static int INITIAL_DIM = 10;
    private int dim;

    @SuppressWarnings("unchecked")
    ArrayStack(){
        elems = (E[]) new Object[INITIAL_DIM];
        //  Los únicos elementos
        //  almacenados en el array son los enviados por el método push, donde está garantizado que sean del
        //  tipo E, por lo tanto el casteo es seguro y no puede causar problema alguno
    }

    @Override
    public boolean isEmpty(){
        return dim == 0;
    }

    @Override
    public void push(E elem){
        if(dim == elems.length) {
            resize();
        }
        elems[dim++] = elem;
    }

    @Override
    public E pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return elems[--dim];
    }

    @Override
    public E peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return elems[dim - 1];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for(int i = dim - 1; i >= 0; i--) {
            stringBuilder.append(elems[i]).append(",");
        }
        stringBuilder.setCharAt(stringBuilder.length() - 1, ']');
        return stringBuilder.toString();
    }


    private void resize() {
        elems = Arrays.copyOf(elems, elems.length + INITIAL_DIM);
    }
}

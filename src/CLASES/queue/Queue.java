package CLASES.queue;

import java.util.Iterator;

public interface Queue<E> extends Iterable<E> {     // me traigo todo lo de Iterable
    void enqueue(E elem);
    E dequeue();
    boolean isEmpty();
}

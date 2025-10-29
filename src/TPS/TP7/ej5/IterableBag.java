package TPS.TP7.ej5;

public interface IterableBag<E> extends Bag<E>{
    /**
     * Para iterar, en orden descendente, por todos los elementos que hay en la bolsa.
     */
    Iterable<E> elements();
    /**
     * Para iterar, en orden descendente, por todos los elementos distintos
     * que hay en la bolsa.
     */
    Iterable<E> elementsDistinct();
}

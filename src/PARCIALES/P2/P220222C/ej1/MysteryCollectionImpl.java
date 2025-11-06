package PARCIALES.P2.P220222C.ej1;

import java.util.*;

public class MysteryCollectionImpl<T extends Comparable<? super T>> extends TreeSet<T> implements MysteryCollection<T>{
    MysteryCollectionImpl() {
        super(Comparator.reverseOrder());       /// PORQUE SE ORDENAN DE MAYOR A MENOR
    }

    public <E extends Comparable<? super E>> Collection<Pair<T, E>> zip(MysteryCollection<E> other){
        Iterator<T> it1 = this.iterator();
        Iterator<E> it2 = other.iterator();
        List<Pair<T, E>> toReturn = new ArrayList<>();
        while(it1.hasNext() && it2.hasNext()){
            toReturn.add(new Pair<>(it1.next() , it2.next()));
        }
        return toReturn;
    }
}

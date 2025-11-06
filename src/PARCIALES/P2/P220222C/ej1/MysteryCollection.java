package PARCIALES.P2.P220222C.ej1;

import java.util.Collection;
import java.util.SortedSet;

public interface MysteryCollection<T extends Comparable<? super T>> extends SortedSet<T> {
    <E extends Comparable<? super E>> Collection<Pair<T, E>> zip(MysteryCollection<E> other);
    ///  TENGO QUE DEFINIR QUIEN ES E
}



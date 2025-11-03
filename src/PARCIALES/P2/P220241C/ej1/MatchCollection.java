package PARCIALES.P2.P220241C.ej1;

import java.util.List;
import java.util.SortedSet;
import java.util.function.Predicate;

public interface MatchCollection<T extends Comparable<? super T>> extends List<T> {

    public void addMatchPredicate(Predicate<T> pred);

    public SortedSet<T> getAllMatched();

    public SortedSet<T> getAllMatchedReversed();
}

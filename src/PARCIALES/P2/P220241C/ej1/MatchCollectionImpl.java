package PARCIALES.P2.P220241C.ej1;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Predicate;

public class MatchCollectionImpl<T extends Comparable<? super T>> extends ArrayList<T> implements MatchCollection<T>{
    private List<Predicate<T>> predicados = new ArrayList<>();

    @Override
    public void addMatchPredicate(Predicate<T> pred) {
        predicados.add(pred);
    }

    @Override
    public SortedSet<T> getAllMatched() {
        SortedSet<T> toReturn = new TreeSet<>();
        for (T elem : this){
            if(checksAll(elem)){
                toReturn.add(elem);
            }
        }
        return toReturn;
    }

    private boolean checksAll(T elem){
        for (Predicate<T> pred : predicados){
            if(!pred.test(elem)){
                return false;
            }
        }
        return true;
    }

    @Override
    public SortedSet<T> getAllMatchedReversed() {
        return getAllMatched().reversed();
    }
}

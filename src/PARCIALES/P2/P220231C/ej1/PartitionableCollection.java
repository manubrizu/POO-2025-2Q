package PARCIALES.P2.P220231C.ej1;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PartitionableCollection<T> extends ArrayList<T> {

    public PartitionableCollection<T> getSelected(Predicate<T> p){
        PartitionableCollection<T> toReturn = new PartitionableCollection<>();
        for(T elem : this){
            if(p.test(elem)){
                toReturn.add(elem);
            }
        }
        return toReturn;
    }

    public PartitionableCollection<T> getRejected(Predicate<T> p){
        return getSelected(p.negate());
    }
}

package PARCIALES.P2.P220232C.ej2;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ScoreBoard<T extends Comparable<? super T>> extends TreeSet<PlayerScore<T>> {
    public List<PlayerScore<T>> getTopScores(int cant){
        List<PlayerScore<T>> toReturn = new ArrayList<>();
        int i = 0;
        for(PlayerScore<T> player : this){
            if(i >= cant){
                break;
            }
            toReturn.add(player);
            i++;
        }
        return toReturn;
    }
}

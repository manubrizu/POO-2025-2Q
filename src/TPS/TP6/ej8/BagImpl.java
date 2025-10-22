package TPS.TP6.ej8;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class BagImpl<T> implements Bag<T>{
    private Map<T, Integer> map = new HashMap<>();

    @Override
    public void add(T elem) {
        map.merge(elem, 1, Integer::sum);
    }

    @Override
    public void remove(T elem) {
        if(!map.containsKey(elem)){
            throw new NoSuchElementException();
        }
        if (map.get(elem) == 1){
            map.remove(elem);   // si no queda ninguno lo vuelo a la mierda
        }
        else{
            map.merge(elem, -1, Integer::sum);
        }
    }

    @Override
    public int count(T elem) {
        return map.getOrDefault(elem, 0);
    }

    @Override
    public boolean contains(T elem) {
        return map.containsKey(elem);
    }

    @Override
    public int size() {
        int toReturn = 0;
        for (int i : map.values()){
            toReturn += i;
        }
        return toReturn;
    }

    @Override
    public int sizeDistinct() {
        return map.size();  // cuenta cuantos elementos distintos hay, y es igual a la cantidad de claves que hay en el mapa
    }
}

package TPS.TP7.ej6;

import java.util.*;

public class MultiMapImpl<K, V extends Comparable<? super V>> implements MultiMap<K,V>{
    private Map<K, Set<V>> multiMap = new HashMap<>();

    @Override
    public void put(K key, V value) {
        if(! multiMap.containsKey(key)){
            multiMap.put(key, new TreeSet<>(Comparator.reverseOrder()));
        }
        multiMap.get(key).add(value);
    }

    @Override
    public int size() {
        int toReturn = 0;
        for(K key : multiMap.keySet()) {
            toReturn += multiMap.get(key).size();
        }
//        for(Set<V> value : multiMap.values()){
//            toReturn += value.size();
//        }
        return toReturn;
    }

    @Override
    public int size(K key) {                // getOrDefault
        if(!multiMap.containsKey(key)) {
            return 0;
        }
        return multiMap.get(key).size();
    }

    @Override
    public void remove(K key) {
        multiMap.remove(key);
    }

    @Override
    public void remove(K key, V value) {        // getOrDefault
        if(multiMap.containsKey(key)){
            multiMap.get(key).remove(value);
        }
    }

    @Override
    public Iterable<V> get(K key) {
        return multiMap.get(key);
    }
}

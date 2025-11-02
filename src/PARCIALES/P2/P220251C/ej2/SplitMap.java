package PARCIALES.P2.P220251C.ej2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;

public class SplitMap<K, V> extends HashMap<K, V> {
    public SplitMap<K, V> split(Predicate<K> predKey){
        return split(predKey, v -> true);
    }

    public SplitMap<K, V> split(Predicate<K> predKey, Predicate<V> predVal){
        SplitMap<K, V> toReturn = new SplitMap<>();
        Iterator<Map.Entry<K, V>> entryIt = entrySet().iterator();
        while( entryIt.hasNext() ){
            Map.Entry<K, V> entry = entryIt.next();
            K currentKey = entry.getKey();
            V currentVal = entry.getValue();
            if (predKey.test(currentKey) && predVal.test(currentVal)){
                entryIt.remove();
                toReturn.put(currentKey, currentVal);
            }
        }
        return toReturn;
    }
}

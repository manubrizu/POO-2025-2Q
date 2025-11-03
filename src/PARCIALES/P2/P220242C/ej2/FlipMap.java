package PARCIALES.P2.P220242C.ej2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BinaryOperator;

public class FlipMap<K, V> extends TreeMap<K, V> {
    public Map<V, K> flip(K base, BinaryOperator<K> joinFunction){
        return flip(entrySet(), base, joinFunction);
    }

    public Map<V, K> flipInverse(K base, BinaryOperator<K> joinFunction){
        return flip(reversed().entrySet(), base, joinFunction);
    }


    private Map<V, K> flip(Set<Map.Entry<K, V>> set, K base, BinaryOperator<K> joinFunction){
        Map<V, K> toReturn = new HashMap<>();
        for(Map.Entry<K, V> entry : set){
            K flipCurrentVal = toReturn.getOrDefault(entry.getValue(), base);
            toReturn.put(entry.getValue(), joinFunction.apply(flipCurrentVal, entry.getKey()));
        }
        return toReturn;
    }
}

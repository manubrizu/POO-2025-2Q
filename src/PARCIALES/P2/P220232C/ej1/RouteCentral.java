package PARCIALES.P2.P220232C.ej1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class RouteCentral {
    private Map<String, Map<String, Integer>> map = new HashMap<>();
    private Function<Integer, Integer> foo;

    RouteCentral(Function<Integer, Integer> foo){
        this.foo = foo;
    }

    public void addOneWayRoute(String from, String to, int miles){
        map.putIfAbsent(from, new HashMap<>());
        map.get(from).putIfAbsent(to, miles);
    }

    public int getDirectRouteMiles(String from, String to){
        if( !map.containsKey(from) || !map.get(from).containsKey(to)){
            throw new IllegalArgumentException("Route does not exists.");
        }
        return map.get(from).get(to);
    }

    public void changeRouteCost(String from, String to, int newMiles){
        if( !map.containsKey(from) || !map.get(from).containsKey(to)){
            throw new IllegalArgumentException("Route does not exists.");
        }
        map.get(from).put(to, newMiles);
    }

    public void addTwoWayRoute(String from, String to, int miles){
        int split_miles = foo.apply(miles);
        addOneWayRoute(from, to, split_miles);
        addOneWayRoute(to, from, split_miles);
    }

    public int getOneStopRouteMiles(String from, String stop, String to){
        return getDirectRouteMiles(from, stop) + getDirectRouteMiles(stop, to);
    }
}

package PARCIALES.P20241C.ej2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class Airport {
    private Counter[] vec;
    private int index;
    private static final int BLOCK = 10;

    Airport(){
        vec = new Counter[BLOCK];
    }

    public Counter AddCounter(String airlineName){
        if(index >= vec.length){
            resize();
        }
        Counter aux = new Counter(index, airlineName);
        vec[index++] = aux;
        return aux;
    }

    public void counterCheckIn(Predicate<Counter> predicate) {
        for(int i = 0; i < index; i++) {
            if(predicate.test(vec[i])) {        ///  a la que cumpla la condicion se corta todo
                vec[i].checkIn();
                break;
            }
        }
    }

    private Counter[] orderCopy(Comparator<Counter> comparator) {
        Counter[] aux = Arrays.copyOf(vec, index);
        Arrays.sort(aux, comparator);
        return aux;
    }

    /// Predicate<Counter> idleAndStartsWithA = new Predicate<Counter>() {
    ///     @Override
    ///     public boolean test(Counter checkInCounter) {
    ///         return !checkInCounter.isCheckIn() & checkInCounter.getAirline().startsWith("A");
    ///     }
    /// };

    public Counter[] airlineOrderCounters() {
        return orderCopy(Comparator.naturalOrder());
    }

    public Counter[] airlineDescendingOrderCounters() {
        return orderCopy(Comparator.reverseOrder());
    }

    private void resize(){
        vec = Arrays.copyOf(vec, vec.length + BLOCK);
    }
}

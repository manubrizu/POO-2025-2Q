package TPS.TP6.ej9;

import java.sql.Time;
import java.util.*;

public class TimeSetImpl<T extends Comparable<? super T>> implements TimeSet<T>{
    private Set<TimeData<T>> set = new TreeSet<>(
            Comparator.<TimeData<T>> comparingInt(TimeData::getHours).thenComparing(TimeData::getMinutes).thenComparing(TimeData::getElem)
    );


    @Override
    public void add(T elem, int hours, int minutes) {
        TimeData<T> timeData = new TimeData<>(elem, hours, minutes);
        remove(timeData.getElem());
        set.add(timeData);
    }

    @Override
    public void remove(T elem) {
        Iterator<TimeData<T>> iterator = set.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().getElem().equals(elem)) {
                iterator.remove();
                break;
            }
        }
    }


    @Override
    public int size() {
        return set.size();
    }
    @Override
    public boolean contains(T elem) {
        for (TimeData<T> datum : set) {
            if (datum.getElem().equals(elem)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public Set<T> retrieve(int hoursFrom, int minutesFrom, int hoursTo, int minutesTo)
    {
        Set<T> response = new HashSet<>();
        for(TimeData<T> timeData : set) {
            if(timeData.getHours() > hoursTo) {
                // Optimización con colección ordenada cronológicamente
                break;
            }
            if(timeData.between(hoursFrom, minutesFrom, hoursTo, minutesTo)) {
                response.add(timeData.getElem());
            }
        }
        return response;
    }
}

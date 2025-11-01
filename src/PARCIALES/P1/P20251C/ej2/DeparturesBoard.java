package PARCIALES.P1.P20251C.ej2;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;

public class DeparturesBoard {
    private static final int BLOCK = 10;
    private Departure[] vec;
    private int dim;
    private LocalTime currentTime;

    public DeparturesBoard(LocalTime currentTime) {
        setCurrentTime(currentTime);
        vec = new Departure[BLOCK];
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
    }

    public boolean hasDeparted(LocalTime departureTime) {
        return currentTime.isAfter(departureTime);
    }

    public boolean addDeparture(LocalTime time, String destination, int platform) {
        Departure departure = new Departure(this, time, destination, platform);
        if (!containsDeparture(departure)) {
            if (dim == vec.length) {
                resize();
            }
            vec[dim++] = departure;
            return true;
        }
        return false;
    }

    private boolean containsDeparture(Departure departure) {
        for (int i = 0; i < dim; i++) {
            if (vec[i].equals(departure)) {
                return true;
            }
        }
        return false;
    }

    private void resize() {
        vec = Arrays.copyOf(vec, dim + BLOCK);
    }

    public Departure[] getDepartures() {
        return Arrays.copyOf(vec, dim);
    }
    public Departure[] getDeparturesDescendingByPlatform() {
        return getSortedCopy(Comparator.naturalOrder());
    }
    public Departure[] getDeparturesAscendingByPlatform() {
        return getSortedCopy(Comparator.reverseOrder());
    }
    private Departure[] getSortedCopy(Comparator<Departure> comparator) {
        Departure[] copy = getDepartures();
        Arrays.sort(copy, comparator);
        return copy;
    }
}

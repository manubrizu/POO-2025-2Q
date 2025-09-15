package TPS.TP5.ej12;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LocalDateInterval implements Iterable<LocalDate> {
    private LocalDate from, to;
    private int intervalo;
    
    public LocalDateInterval(LocalDate from, LocalDate to, int intervalo) {
        this.from = from;
        this.to = to;
        this.intervalo = intervalo;
    }

    @Override
    public Iterator<LocalDate> iterator() {
        return new LocalDateIntervalIterator();
    }

    private class LocalDateIntervalIterator implements Iterator<LocalDate> {
        private LocalDate current = from;

        @Override
        public boolean hasNext() {
            return intervalo > 0 && !current.isAfter(to) || intervalo < 0 && !current.isBefore(to);
        }

        @Override
        public LocalDate next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            LocalDate aux = current;
            current = current.plusDays(intervalo);
            return aux;
        }
    }
}

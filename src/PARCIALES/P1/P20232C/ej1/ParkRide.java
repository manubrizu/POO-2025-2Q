package PARCIALES.P1.P20232C.ej1;

import java.time.LocalTime;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ParkRide implements Iterable<ParkSlot>{
    private String parkName;
    private LocalTime openTime, closeTime;
    private int espacio;

    ParkRide(String name, LocalTime openTime, LocalTime closeTime, int espacio) {
        if (espacio <= 0){
            throw new IllegalArgumentException("Slot minutes must be positive");
        }
        this.parkName = name;
        this.openTime = openTime;
        this.espacio = espacio;
        setCloseTime(closeTime);
    }

    public void setCloseTime(LocalTime closeTime){
        if (closeTime.isBefore(openTime)) {
            throw new IllegalArgumentException("Close time cannot be before open time");
        }
        this.closeTime = closeTime;
    }

    @Override
    public Iterator<ParkSlot> iterator(){
        return new ParkSlotIterator();
    }

    public class ParkSlotIterator implements Iterator<ParkSlot>{
        private LocalTime currentTime = openTime;
        private final LocalTime closeTimeIt = closeTime;    /// ESTO ES IMPORTANTE PORQUE EL CLOSE TIME DEL ITERATOR
                                                            /// NO DEBE CAMBIAR SI SE CAMBIA EL "closeTime"
        @Override
        public boolean hasNext() {
            return currentTime.isBefore(closeTimeIt);
        }

        @Override
        public ParkSlot next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            ParkSlot aux = new ParkSlot(parkName, currentTime);
            currentTime = currentTime.plusMinutes(espacio);
            return aux;
        }
    }



}

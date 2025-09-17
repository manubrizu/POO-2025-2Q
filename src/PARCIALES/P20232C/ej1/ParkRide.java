package PARCIALES.P20232C.ej1;

import java.time.LocalTime;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ParkRide implements Iterable<ParkSlot>{
    private String parkName;
    private LocalTime openTime, closeTime;
    private long size;
    private ParkSlot[] slots;

    ParkRide(String name, LocalTime openTime, LocalTime closeTime, long minute) {
        this.parkName = name;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.size = ((closeTime.toSecondOfDay() - openTime.toSecondOfDay()) / 60) / minute;
        slots = new ParkSlot[(int) size];
    }

    public void setCloseTime(LocalTime newCloseTime){
        if (newCloseTime.isBefore(openTime)) {
            throw new IllegalArgumentException("puto");
        }
        this.closeTime = newCloseTime;
    }

    @Override
    public Iterator<ParkSlot> iterator(){
        return new ParkSlotIterator();
    }

    public class ParkSlotIterator implements Iterator<ParkSlot>{
        private int currentSlot = 0;

        @Override
        public boolean hasNext() {
            return currentSlot < size;
        }

        @Override
        public ParkSlot next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            ParkSlot elem = slots[currentSlot++];
            return elem;
        }
    }



}

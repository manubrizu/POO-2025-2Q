package PARCIALES.P20232C.ej1;

import java.time.LocalTime;

public class ParkSlot {
    private final String rideName;
    private final LocalTime startTime;

    public ParkSlot(String rideName, LocalTime startTime) {
        this.rideName = rideName;
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return String.format("%s <> %02d:%02d Slot", rideName, startTime.getHour(), startTime.getMinute());
    }
}

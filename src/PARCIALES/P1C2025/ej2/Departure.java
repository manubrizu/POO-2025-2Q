package PARCIALES.P1C2025.ej2;

import java.time.LocalTime;
import java.util.Objects;

public class Departure implements Comparable<Departure>{
    private DeparturesBoard board;
    private LocalTime departureTime;
    private String destinationName;
    private int platformNumber;

    public Departure(DeparturesBoard departuresBoard, LocalTime departureTime, String destinationName, int platformNumber) {
        this.board = departuresBoard;
        this.departureTime = departureTime;
        this.destinationName = destinationName;
        this.platformNumber = platformNumber;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Departure departure && platformNumber == departure.platformNumber &&
                departureTime.equals(departure.departureTime) &&
                destinationName.equals(departure.destinationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureTime, destinationName, platformNumber);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d | %-10s | P%02d | %s", departureTime.getHour(), departureTime.getMinute(), destinationName, platformNumber, board.hasDeparted(departureTime) ? "DEPARTED" : "ON TIME");
    }

    @Override
    public int compareTo(Departure o) {
        int cmp = Integer.compare(o.platformNumber, platformNumber);
        if(cmp == 0) {
            cmp = departureTime.compareTo(o.departureTime);
            if (cmp == 0) {
                cmp = destinationName.compareTo(o.destinationName);
            }
        }
        return cmp;
    }

}

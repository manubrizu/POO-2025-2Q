package PARCIALES.P20232C.ej2;

import java.util.ArrayList;
import java.util.List;

public class Lounge {
    protected String loungeName;
    protected List<Passenger> passengers;
    protected LoungeCentral central;

    Lounge(LoungeCentral central, String loungeName) {
        this.central = central;
        this.loungeName = loungeName;
        this.passengers = new ArrayList<>();
    }

    public void enter(Passenger passenger) {
        if (!central.isOpen()) {
            throw new IllegalStateException("Cannot enter lounge");
        }
        if (passenger.getPases() <= 0) {
            throw new IllegalStateException("No passes available");
        }
        if (!canEnter(passenger)) {
            throw new IllegalStateException("Cannot enter lounge");
        }
        passenger.usarPase();
        passengers.add(passenger);
    }

    protected boolean canEnter(Passenger passenger) {
        return true;
    }

    public void exit(int n) {
        if (passengers.isEmpty()) {
            throw new IllegalStateException("Lounge is empty");
        }
        if (n <= 0 || n > passengers.size()) {
            throw new IllegalStateException("Not enough guests to exit");
        }
        for (int i = 0; i < n && !passengers.isEmpty(); i++) {
            passengers.remove(passengers.size() - 1);
        }
    }

    public void exit() {
        exit(1);
    }

    public int getNumberOfPassenger() {
        return passengers.size();
    }

    @Override
    public String toString() {
        return loungeName + " has " + getNumberOfPassenger() + " guests";
    }
}

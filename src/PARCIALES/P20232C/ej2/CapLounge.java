package PARCIALES.P20232C.ej2;

public class CapLounge extends Lounge {
    private final int maxPassengers;

    CapLounge(LoungeCentral central, String loungeName, int maxPassengers) {
        super(central, loungeName);
        this.maxPassengers = maxPassengers;
    }

    @Override
    protected boolean canEnter(Passenger passenger) {
        return getNumberOfPassenger() < maxPassengers;
    }

    @Override
    public String toString() {
        return super.toString() + " up to " + maxPassengers + " guests";
    }
}

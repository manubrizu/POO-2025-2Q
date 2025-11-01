package PARCIALES.P1.P20232C.ej2;

public class AirlineCapLounge extends CapLounge{
    private String airlineName;

    AirlineCapLounge(LoungeCentral central, String loungeName, int maxNumberOfPassengers, String airlineName){
        super(central, loungeName, maxNumberOfPassengers);
        this.airlineName = airlineName;
    }

    @Override
    protected boolean canEnter(Passenger passenger) {
        return super.canEnter(passenger) && passenger.getAirlineName().equals(airlineName);
    }

}

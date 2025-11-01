package PARCIALES.P1.P20232C.ej2;

public class Passenger {
    private String name, airlineName;
    private int pases;

    public Passenger(String name, String airlineName, int pases) {
        this.name = name;
        this.airlineName = airlineName;
        this.pases = pases;
    }

    public String getName() {
        return name;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public int getPases() {
        return pases;
    }

    public void usarPase(){
        if(pases == 0){
            throw new IllegalArgumentException("puto");
        }
        pases--;
    }

    public boolean matchAirline(String airline) {
        return this.airlineName.equals(airline);
    }
}

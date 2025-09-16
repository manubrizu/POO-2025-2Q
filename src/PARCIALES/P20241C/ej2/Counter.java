package PARCIALES.P20241C.ej2;

public class Counter implements Comparable<Counter>{
    private int counterNumber;
    private String airlineName;
    private boolean status;

    public Counter(int counterNumber, String airlineName) {
        this.counterNumber = counterNumber;
        this.airlineName = airlineName;
        this.status = false;
    }

    public String getAirline() {
        return this.airlineName;
    }

    public boolean isCheckIn() {
        return this.status;
    }

    public void checkIn() {
        this.status = true;
    }

    @Override
    public int compareTo(Counter o){
        int cmp = this.airlineName.compareTo(o.airlineName);
        if(cmp == 0){
            cmp = Integer.compare(this.counterNumber, o.counterNumber);
        }
        return cmp;
    }

    @Override
    public String toString() {
        return "Counter %d for %s is %s".formatted(counterNumber, airlineName, status ? "checking in" : "idle");
    }
}

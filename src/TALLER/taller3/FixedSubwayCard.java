package TALLER.taller3;

public class FixedSubwayCard extends SubwayCard {
    private int rides;

    FixedSubwayCard(SubwayCentral sc, int rides) {
        super(sc);
        this.rides = rides;
    }

    @Override
    protected boolean canRide(){
        return this.rides != 0;
    }

    @Override
    public void ride() {
        if (canRide()) {
            rides--;
        }
        else{
            System.out.println("You can no longer viajar");
        }
    }
}

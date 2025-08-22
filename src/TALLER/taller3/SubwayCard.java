package TALLER.taller3;

public abstract class SubwayCard {
    private SubwayCentral subwayCentral;

    SubwayCard(SubwayCentral sc) {
        this.subwayCentral = sc;
    }

    protected abstract boolean canRide();

    protected SubwayCentral getSubwayCentral(){
        return this.subwayCentral;
    }

    public abstract void ride() throws CannotRideException;
}

package TALLER.taller4.ejparcial;

import java.time.LocalTime;

public abstract class Pier {
    private String ferryName;
    private Ferry[] pier;
    private FerryCompany ferryCompany;

    Pier(String ferryName, FerryCompany ferryCompany, int numberOfPiers){
        this.ferryName = ferryName;
        this.ferryCompany = ferryCompany;
        this.pier = new Ferry[numberOfPiers];
    }

    public abstract void dock(Ferry ferry, LocalTime localTime) throws CannotDockException;
    public abstract void undock(Ferry ferry, LocalTime localTime) throws CannotUndockException;

    protected abstract boolean canDock(Ferry ferry, LocalTime localTime) throws CannotDockException;
    protected abstract boolean canUndock(Ferry ferry, LocalTime localTime) throws CannotUndockException;

    protected FerryCompany getCompany(){
        return ferryCompany;
    }

    protected Ferry[] getPier(){
        return this.pier;
    }

}

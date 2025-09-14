package TALLER.ejparcial.catedra;

import TALLER.taller4.catedra.Ferry;
import TALLER.taller4.catedra.FerryCompany;
import TALLER.taller4.catedra.TimedFerryPort;

import java.time.LocalTime;

public class LastInFerryPort extends TimedFerryPort {
    private Ferry lastDocked;
    public LastInFerryPort(String name, FerryCompany fc, int docks, LocalTime o, LocalTime c) {
        super(name, fc, docks, o, c);
    }
    @Override
    public void dock(Ferry ferry, LocalTime localTime) {
        super.dock(ferry, localTime);
        lastDocked = ferry;
    }
    @Override
    public void undock(Ferry ferry, LocalTime localTime) {
        if(lastDocked == ferry) {
            throw new RuntimeException();
        }
        super.undock(ferry, localTime);
        lastDocked = null;
    }
}

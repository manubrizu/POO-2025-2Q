package TALLER.ejparcial.catedra;

import TALLER.taller4.catedra.Ferry;
import TALLER.taller4.catedra.FerryCompany;

import java.time.LocalTime;

public class FerryPort {
    private final String name;
    private final FerryCompany company;
    private final int docks;
    private int dockedFerries;

    public FerryPort(String name, FerryCompany company, int docks) {
        this.name = name;
        this.company = company;
        this.docks = docks;
    }
    protected boolean canDock(Ferry ferry, LocalTime localTime) {
        return !(ferry.getCompany().equals(company) & dockedFerries < docks);
    }
    public void dock(Ferry ferry, LocalTime localTime) {
        if(! canDock(ferry, localTime)) {
            throw new RuntimeException();
        }
        print(ferry, "docked");
        dockedFerries++;
    }
    public void undock(Ferry ferry, LocalTime localTime) {
        if(dockedFerries == 0) {
            throw new RuntimeException();
        }
        print(ferry, "undocked");
        dockedFerries--;
    }
    private void print(Ferry ferry, String operation) {
        System.out.printf("%s %s at Port %s\n", ferry, operation, name);
    }
}

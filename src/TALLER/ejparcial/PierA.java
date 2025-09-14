package TALLER.ejparcial;

import TALLER.taller4.CannotDockException;
import TALLER.taller4.FerryCompany;
import TALLER.taller4.Pier;

import java.time.LocalTime;

public class PierA extends Pier {
    private String portName;

    public PierA(String portName, FerryCompany ferryCompany, int numberOfPiers) {
        super(portName, ferryCompany, numberOfPiers);
        this.portName = portName;
    }

    @Override
    public void dock(TALLER.taller4.Ferry ferry, LocalTime localTime) throws CannotDockException {
        if (canDock(ferry, localTime)) {
            // Find first available pier and dock the ferry
            for (int i = 0; i < getPier().length; i++) {
                if (getPier()[i] == null) {
                    getPier()[i] = ferry;
                    System.out.println("Ferry " + ferry + " docked at Port " + portName);
                    return;
                }
            }
        }
    }

    @Override
    public void undock(TALLER.taller4.Ferry ferry, LocalTime localTime) throws TALLER.taller4.CannotUndockException {
        if (canUndock(ferry, localTime)) {
            // Find and remove the ferry (any ferry can be undocked)
            for (int i = 0; i < getPier().length; i++) {
                if (getPier()[i] != null) {
                    getPier()[i] = null;
                    System.out.println("Ferry " + ferry + " undocked at Port " + portName);
                    return;
                }
            }
        }
    }

    @Override
    protected boolean canDock(TALLER.taller4.Ferry ferry, LocalTime localTime) throws CannotDockException {
        boolean hasAvailablePier = false;
        for (int i = 0; i < getPier().length; i++) {
            if (getPier()[i] == null) {
                hasAvailablePier = true;
                break;
            }
        }

        boolean sameCompany = getCompany().equals(ferry.getCompany());

        if (!hasAvailablePier || !sameCompany) {
            throw new CannotDockException("Cannot dock");
        }

        return true;
    }

    @Override
    protected boolean canUndock(Ferry ferry, LocalTime localTime) throws CannotUndockException {
        boolean hasOccupiedPier = false;
        for (int i = 0; i < getPier().length; i++) {
            if (getPier()[i] != null) {
                hasOccupiedPier = true;
                break;
            }
        }

        if (!hasOccupiedPier) {
            throw new CannotUndockException("Cannot undock");
        }

        return true;
    }
}
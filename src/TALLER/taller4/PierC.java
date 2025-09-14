package TALLER.taller4;

import java.time.LocalTime;

public class PierC extends PierB {
    private Ferry lastDockedFerry;

    public PierC(String portName, FerryCompany ferryCompany, int numberOfPiers, LocalTime openingTime, LocalTime closingTime) {
        super(portName, ferryCompany, numberOfPiers, openingTime, closingTime);
        this.lastDockedFerry = null;
    }

    @Override
    public void dock(Ferry ferry, LocalTime localTime) throws CannotDockException {
        if (canDock(ferry, localTime)) {
            // Find first available pier and dock the ferry
            for (int i = 0; i < getPier().length; i++) {
                if (getPier()[i] == null) {
                    getPier()[i] = ferry;
                    lastDockedFerry = ferry; // Track the last docked ferry
                    System.out.println("Ferry " + ferry + " docked at Port " + getPortName());
                    return;
                }
            }
        }
    }

    @Override
    public void undock(Ferry ferry, LocalTime localTime) throws CannotUndockException {
        if (canUndock(ferry, localTime)) {
            // Find and remove the ferry
            for (int i = 0; i < getPier().length; i++) {
                if (getPier()[i] != null && getPier()[i].equals(ferry)) {
                    getPier()[i] = null;
                    lastDockedFerry = null; // Reset last docked ferry after undocking
                    System.out.println("Ferry " + ferry + " undocked at Port " + getPortName());
                    return;
                }
            }
        }
    }

    @Override
    protected boolean canUndock(Ferry ferry, LocalTime localTime) throws CannotUndockException {
        // Check if there's at least one occupied pier
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

        if (lastDockedFerry == null || !lastDockedFerry.equals(ferry)) {
            throw new CannotUndockException("Cannot undock");
        }
        
        return true;
    }
}

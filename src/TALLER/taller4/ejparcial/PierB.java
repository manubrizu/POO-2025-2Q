package TALLER.taller4.ejparcial;

import java.time.LocalTime;

public class PierB extends Pier {
    private String portName;
    private LocalTime openingTime;
    private LocalTime closingTime;

    public PierB(String portName, FerryCompany ferryCompany, int numberOfPiers, LocalTime openingTime, LocalTime closingTime) {
        super(portName, ferryCompany, numberOfPiers);
        this.portName = portName;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    protected String getPortName() {
        return portName;
    }

    @Override
    public void dock(Ferry ferry, LocalTime localTime) throws CannotDockException {
        if (canDock(ferry, localTime)) {
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
    public void undock(Ferry ferry, LocalTime localTime) throws CannotUndockException {
        if (canUndock(ferry, localTime)) {
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
    protected boolean canDock(Ferry ferry, LocalTime localTime) throws CannotDockException {
        boolean hasAvailablePier = false;
        for (int i = 0; i < getPier().length; i++) {
            if (getPier()[i] == null) {
                hasAvailablePier = true;
                break;
            }
        }

        boolean sameCompany = getCompany().equals(ferry.getCompany());
        boolean withinOperatingHours = !localTime.isBefore(openingTime) && !localTime.isAfter(closingTime);

        if (!hasAvailablePier || !sameCompany || !withinOperatingHours) {
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
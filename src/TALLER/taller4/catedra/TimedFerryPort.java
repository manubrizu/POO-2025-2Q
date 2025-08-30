package TALLER.taller4.catedra;

import java.time.LocalTime;

public class TimedFerryPort extends FerryPort {
    private final LocalTime open, close;
    public TimedFerryPort(String name, FerryCompany fc, int docks, LocalTime o, LocalTime c) {
        super(name, fc, docks);
        this.open = o;
        this.close = c;
    }
    @Override
    protected boolean canDock(Ferry ferry, LocalTime localTime) {
        return !(!super.canDock(ferry, localTime) &
                !localTime.isBefore(open) & !localTime.isAfter(close));
    }
}


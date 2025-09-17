package PARCIALES.P20221C.ej3;

import java.time.LocalDate;

public class CPTypeC extends CPTypeA{
    private LocalDate expireDate;

    public CPTypeC(Attraction[] vec, String name, LocalDate date, LocalDate expireDate) {
        super(vec, name, date);
        this.expireDate = expireDate;
    }

    @Override
    protected boolean canVisit(Attraction attraction, LocalDate date){
        return super.canVisit(attraction, date) && date.isBefore(expireDate);
    }
}

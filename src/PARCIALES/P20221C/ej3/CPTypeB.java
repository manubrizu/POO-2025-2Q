package PARCIALES.P20221C.ej3;

import java.time.LocalDate;

public class CPTypeB extends CPTypeA{
    private int maxVisitas;

    public CPTypeB(Attraction[] vec, String name, LocalDate date, int maxVisitas) {
        super(vec, name, date);
        this.maxVisitas = maxVisitas;
    }

    @Override
    protected boolean canVisit(Attraction attraction, LocalDate date){
        return super.canVisit(attraction, date) && super.getVisitas() < maxVisitas;
    }
}

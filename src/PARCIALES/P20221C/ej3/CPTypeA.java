package PARCIALES.P20221C.ej3;

import java.time.LocalDate;

public class CPTypeA implements CityPass{
    private Attraction[] vec;
    private String name;
    private LocalDate date;
    private int visitas;

    public CPTypeA(Attraction[] vec, String name, LocalDate date) {
        this.vec = vec;
        this.name = name;
        this.date = date;
    }

    @Override
    public void visit(Attraction attraction, LocalDate date) {
        if(!canVisit(attraction, date)){
            throw new CannotVisitAttractionException(attraction);
        }
        System.out.printf("%s visited %s", name, attraction);
        this.visitas++;
    }

    protected boolean canVisit(Attraction attraction, LocalDate date){
        return belongsIn(attraction) && this.date.isBefore(date);
    }

    @Override
    public Attraction[] getAttractions(){
        return vec;
    }

    public int getVisitas(){
        return this.visitas;
    }

    @Override
    public String toString(){
        return "CityPass for %s used for %d attractions".formatted(name, visitas);
    }
}

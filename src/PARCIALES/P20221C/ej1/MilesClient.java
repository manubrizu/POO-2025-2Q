package PARCIALES.P20221C.ej1;

import java.util.Iterator;

public class MilesClient implements Iterable<String>{
    private String name;
    private int months;
    private PlanType plan;

    public MilesClient(String name, int months, PlanType plan) {
        this.name = name;
        this.months = months;
        this.plan = plan;
    }

    @Override
    public Iterator<String> iterator(){
        return new MilesClientIterator();
    }

    public class MilesClientIterator implements Iterator<String>{
        private int currentMonth = 1;

        @Override
        public boolean hasNext(){
            return currentMonth <= months;
        }

        @Override
        public String next(){
            if(!hasNext()){
                throw new RuntimeException();
            }
            return "Client %s: Month %d earned %d miles for $%.2f".formatted(name, currentMonth, plan.getMiles(currentMonth++), plan.getCost());
        }
    }

}

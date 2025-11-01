package PARCIALES.P1.P20221C.ej3;

import java.util.Objects;

public class Attraction {
    private String attractionName;

    Attraction(String name){
        this.attractionName = name;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Attraction attraction && attractionName.equals(attraction.attractionName);
    }

    @Override
    public int hashCode(){
        return Objects.hash(attractionName);
    }

    @Override
    public String toString(){
        return String.format("%s", attractionName);
    }
}

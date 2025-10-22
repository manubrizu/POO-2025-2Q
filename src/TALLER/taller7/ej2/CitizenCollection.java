package TALLER.taller7.ej2;

import java.util.*;

public class CitizenCollection {
    private SortedSet<Citizen> set = new TreeSet<>();

    ///  private Set<Citizen> set = new TreeSet<>(new Comparator.naturalOrder());

    public CitizenCollection addCitizen(String DNI, String nombre, String apellido){
        set.add(new Citizen(DNI, nombre, apellido));
        return this;
    }

    public Iterable<Citizen> getNaturalOrder(){
        return set;
    }

    public Iterable<Citizen> getReversedOrder(){
        return set.reversed();
    }

    public static class Citizen implements Comparable<Citizen> {
        private String DNI;
        private String nombre;
        private String apellido;

        public Citizen(String DNI, String nombre, String apellido) {
            this.DNI = DNI;
            this.nombre = nombre;
            this.apellido = apellido;
        }
        
        @Override
        public boolean equals(Object o){
            return o instanceof Citizen citizen && 
                    DNI.equals(citizen.DNI) && 
                    nombre.equals(citizen.nombre) && 
                    apellido.equals(citizen.apellido);
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(DNI, nombre, apellido);
        }

        @Override
        public int compareTo(Citizen c){        ///  ORDENA INTERNAMENTE AL IMPLEMENTAR COMPARABLE
            return DNI.compareTo(c.DNI);
        }
    }
}

package TPS.TP6.ej10;

import java.util.Objects;

public class Person {
    private String nombre;
    private int edad;
    
    Person(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public String getName() {
        return nombre;
    }
    public int getAge() {
        return edad;
    }
    @Override
    public String toString() {
        return "%s # %d".formatted(nombre, edad);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Person person &&
                nombre.equals(person.nombre) &&
                edad == person.edad;
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad);
    }

}

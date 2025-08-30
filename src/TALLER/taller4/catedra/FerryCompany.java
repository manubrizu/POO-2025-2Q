package TALLER.taller4.catedra;

public class FerryCompany {
    private final String name;
    public FerryCompany(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o){
        return  o instanceof FerryCompany ferry && this.name.equals(ferry.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

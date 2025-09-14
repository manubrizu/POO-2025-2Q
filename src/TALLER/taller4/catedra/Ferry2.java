package TALLER.taller4.catedra;

public class Ferry2 {
    private final String name;
    private final FerryCompany company;
    public Ferry2(String name, FerryCompany c) {
        this.name = name;
        this.company = c;
    }
    public FerryCompany getCompany() {
        return company;
    }
    @Override
    public String toString() {
        return "Ferry %s".formatted(name);
    }


}


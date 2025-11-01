package PARCIALES.P1.repaso.ej3;

public enum PizzaType {
    HORNO("al horno", 100),
    PARRILLA("a la parrilla", 150);

    private final String description;
    private final double price;

    PizzaType(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}

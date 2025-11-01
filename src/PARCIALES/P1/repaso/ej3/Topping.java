package PARCIALES.P1.repaso.ej3;

public enum Topping {
    EXTRA_CHEESE("Extra queso", 20),
    TOMATO("Tomate", 30),
    ONION("Cebolla", 10);

    private final String description;
    private final double price;

    Topping(String description, double price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}


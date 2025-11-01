package PARCIALES.P1.repaso.ej3;

public class Pizza {
    private final PizzaType type;
    private final Topping[] toppings;

    public Pizza(PizzaType type, Topping[] toppings) {
        this.type = type;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Pizza").append(type.getDescription());
        double totalPrice = type.getPrice();

        for(Topping topping : toppings) {
            stringBuilder.append(String.format(" con %s", topping));
            totalPrice += topping.getPrice();
        }

        stringBuilder.append(": ").append("$").append(String.format("%.02f", totalPrice));
        return stringBuilder.toString();
    }
}


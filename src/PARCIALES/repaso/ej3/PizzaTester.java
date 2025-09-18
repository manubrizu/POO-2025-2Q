package PARCIALES.repaso.ej3;

public class PizzaTester {
    public static void main(String[] args) {
            // Pizza a la parrilla con Tomate
        Topping[] toppings = {Topping.TOMATO};
        Pizza pizza1 = new Pizza(PizzaType.PARRILLA, toppings);

            // Pizza a la parrilla con Tomate con Cebolla con Extra queso
        toppings = new Topping[]{Topping.TOMATO, Topping.ONION, Topping.EXTRA_CHEESE};
        Pizza pizza2 = new Pizza(PizzaType.PARRILLA, toppings);

            // Pizza al horno con Cebolla con Extra queso
        toppings = new Topping[]{Topping.ONION, Topping.EXTRA_CHEESE};
        Pizza pizza3 = new Pizza(PizzaType.HORNO, toppings);

        System.out.println(pizza1);
        System.out.println(pizza2);
        System.out.println(pizza3);
    }
}

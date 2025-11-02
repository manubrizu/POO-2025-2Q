package PARCIALES.P2.P220251C;

public class SplitMapTester {
    public static void main(String[] args) {
        SplitMap<String, Integer> m1 = new SplitMap<>(); // SplitMap con clave String y valor Integer
        m1.put("Four", 4);
        m1.put("One", 1);
        m1.put("Three", 3);

        System.out.println(m1.isEmpty()); // false
        System.out.println(m1.get("One")); // 1
        System.out.println(m1.get("Four")); // 4
        System.out.println(m1.get("Three")); // 3

        // En m1 se remueven todas las entradas tal que la clave contenga la letra "e"
        // y retorna un m2 con las entradas removidas de m1
        SplitMap<String, Integer> m2 = m1.split(k -> k.contains("e"));

        System.out.println(m1.size()); // 1
        System.out.println(m1.get("One")); // null
        System.out.println(m1.get("Four")); // 4
        System.out.println(m1.get("Three")); // null

        System.out.println(m2.size()); // 2
        System.out.println(m2.get("One")); // 1
        System.out.println(m2.get("Four")); // null
        System.out.println(m2.get("Three")); // 3

        SplitMap<Double, String> m3 = new SplitMap<>(); // SplitMap con clave Double y valor String
        m3.put(0.0, "zero");
        m3.put(-5.0, "minus five point zero");
        m3.put(2.0, "two point zero");

        System.out.println(m3.get(-5.0)); // minus five point zero
        System.out.println(m3.get(0.0));  // zero
        System.out.println(m3.get(2.0));  // two point zero

        // En m3 se remueven todas las entradas tal que la clave sea menor a cero
        // y el valor termine con la palabra "zero" y retorna un m4 con las entradas removidas de m3
        SplitMap<Double, String> m4 = m3.split(k -> k < 0, v -> v.endsWith("zero"));

        System.out.println(m3.size()); // 2
        System.out.println(m3.get(-5.0)); // null
        System.out.println(m3.get(0.0));  // zero
        System.out.println(m3.get(2.0));  // two point zero

        System.out.println(m4.size()); // 1
        System.out.println(m4.get(-5.0)); // minus five point zero
        System.out.println(m4.get(0.0));  // null
        System.out.println(m4.get(2.0));  // null

        // Si no hay nada que remover se retorna un SplitMap vacío y el mapa original no cambia
        System.out.println(m3.split(k -> k <= 0).isEmpty()); // true

        // Si hay que remover todo se retorna un SplitMap con todo y el mapa original queda vacío
        System.out.println(m3.split(k -> k >= 0).size()); // 2
        System.out.println(m3.size()); // 0
    }
}
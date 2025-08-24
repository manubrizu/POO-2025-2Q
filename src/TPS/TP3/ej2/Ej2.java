package TPS.TP3.ej2;

public class Ej2 {
    public static void main(String args[]) {
        String s = "hola";
        System.out.println(s instanceof String);                // true
        System.out.println(s instanceof Object);                // true
        System.out.println(s.getClass().equals(String.class));  // true
        System.out.println(s.getClass().equals(Object.class));  // false

        /*
        *   El operador instanceof devuelve verdadero si el primer operando es una instancia de la
        *   clase o una subclase del segundo operando.
        *   Por otro lado, el método "getClass()" devuelve la clase
        *   de la instancia.
        */
    }
}

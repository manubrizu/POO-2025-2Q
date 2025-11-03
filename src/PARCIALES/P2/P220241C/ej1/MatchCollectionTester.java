package PARCIALES.P2.P220241C.ej1;

public class MatchCollectionTester {
    public static void main(String[] args) {
        // Se instancia una colección de "palabras" donde cada elemento está asociado a una posición.
        // La colección acepta repetidos.
        MatchCollection<String> sC = new MatchCollectionImpl<>();

        sC.add("Mundo");
        sC.add("Hola");
        sC.add("Hola");

        System.out.println(sC.size());        // 3
        System.out.println(sC.get(0));        // Mundo
        System.out.println(sC.get(1));        // Hola
        System.out.println(sC.get(2));        // Hola
        System.out.println(sC.contains("Mundo")); // true

        // Se agrega el predicado: "palabras" con longitud mayor o igual a 4 caracteres
        sC.addMatchPredicate(e -> e.length() >= 4);

        // Los predicados no impactan en los elementos ya agregados ni en el agregado de nuevos elementos
        sC.add("Abc");
        sC.add("Wxyz");

        System.out.println(sC.size());        // 5
        System.out.println(sC.get(3));        // Abc

        sC.addMatchPredicate(e -> e.contains("o"));
        sC.add("Lol!");

        // Se obtiene una nueva colección con los elementos que cumplen con TODOS los predicados
        // (palabras de 4 o más caracteres que contengan la letra 'o')
        // SIN REPETIDOS y en orden ASCENDENTE por el elemento
        for (String e : sC.getAllMatched()) {
            System.out.println(e);
        }
        // Hola
        // Lol!
        // Mundo

        // En orden DESCENDENTE
        for (String e : sC.getAllMatchedReversed()) {
            System.out.println(e);
        }
        // Mundo
        // Lol!
        // Hola
    }
}
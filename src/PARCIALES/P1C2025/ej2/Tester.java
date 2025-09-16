package PARCIALES.P1C2025.ej2;

import java.time.LocalTime;
import java.time.Month;

public class Tester {
    public static void main(String[] args) {
        // Ejemplo de uso de la clase java.time.LocalTime
        LocalTime currentTime = LocalTime.of(18, 13);
        System.out.println(currentTime.isAfter(LocalTime.of(18, 11))); // true

        // Se instancia un tablero de partidas donde el tiempo actual del tablero es 18:13
        DeparturesBoard board = new DeparturesBoard(currentTime);

        // Se agregan partidas al tablero
        System.out.println(board.addDeparture(LocalTime.of(18, 35), "Swindown", 3)); // true
        System.out.println(board.addDeparture(LocalTime.of(18, 36), "Salisbury", 1)); // true
        System.out.println(board.addDeparture(LocalTime.of(18, 44), "Gloucester", 2)); // true

        // Se obtienen las partidas en orden DE INSERCIÓN
        System.out.println("\n--- Orden de Inserción ---");
        for (Departure departure : board.getDepartures()) {
            System.out.println(departure);
        }
    /* Salida esperada:
       18:35 | Swindown   | P03 | ON TIME
       18:36 | Salisbury  | P01 | ON TIME
       18:44 | Gloucester | P02 | ON TIME
    */

        // Intento de agregar una partida duplicada
        System.out.println("\n" + board.addDeparture(LocalTime.of(18, 35), "Weymouth", 2)); // true
        System.out.println(board.addDeparture(LocalTime.of(18, 35), "Weymouth", 2)); // false

        // Se modifica el tiempo actual del tablero a 18:36
        board.setCurrentTime(LocalTime.of(18, 36));

        // Se obtienen las partidas en orden DE INSERCIÓN
        System.out.println("\n--- Orden de Inserción (tiempo actualizado) ---");
        for (Departure departure : board.getDepartures()) {
            System.out.println(departure);
        }
    /* Salida esperada:
       18:35 | Swindown   | P03 | DEPARTED
       18:36 | Salisbury  | P01 | ON TIME
       18:44 | Gloucester | P02 | ON TIME
       18:35 | Weymouth   | P02 | DEPARTED
    */

        // Se obtienen las partidas en orden DESCENDENTE por plataforma
        System.out.println("\n--- Orden Descendente por Plataforma ---");
        for (Departure departure : board.getDeparturesDescendingByPlatform()) {
            System.out.println(departure);
        }
    /* Salida esperada:
       18:35 | Swindown   | P03 | DEPARTED
       18:35 | Weymouth   | P02 | DEPARTED
       18:44 | Gloucester | P02 | ON TIME
       18:36 | Salisbury  | P01 | ON TIME
    */

        // Se actualiza el tiempo actual a 18:37
        board.setCurrentTime(LocalTime.of(18, 37));

        // Se obtienen las partidas en orden ASCENDENTE por plataforma
        System.out.println("\n--- Orden Ascendente por Plataforma ---");
        for (Departure departure : board.getDeparturesAscendingByPlatform()) {
            System.out.println(departure);
        }
    /* Salida esperada:
       18:36 | Salisbury  | P01 | DEPARTED
       18:44 | Gloucester | P02 | ON TIME
       18:35 | Weymouth   | P02 | DEPARTED
       18:35 | Swindown   | P03 | DEPARTED
    */
    }
}

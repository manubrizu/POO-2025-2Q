package TPS.TP6.ej7;

import java.util.Collection;

public class Ej7 {
    //  El problema es que no alcanza con agregar el calificador static al método mayor, ya que un
    //  método estático no puede utilizar un tipo genérico definido a nivel clase. Por lo tanto la solución
    //  consiste en definir el tipo genérico a nivel método, como se muestra a continuación:

    public static <T extends Comparable<? super T>> T mayor(Collection<? extends T> valores) {
        if (valores.isEmpty()) {
            return null;
        }

        T mayor = null;
        for (T elem : valores) {
            if (mayor == null || mayor.compareTo(elem) < 0) {
                mayor = elem;
            }
        }

        return mayor;
    }
}

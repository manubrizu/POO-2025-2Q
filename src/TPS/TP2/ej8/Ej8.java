package TPS.TP2.ej8;

public class Ej8 {
    public static void main(String[] args) {
        Double valores[] = {1.1, 2.2, 3.3};
        for (Double valor : valores) {
            valor *= 2;
            System.out.printf("El valor es %g\n", valor);
        }
        for (Double valor : valores) {
            valor *= 2;
            System.out.printf("El valor es %g\n", valor);
        }
    }
}

/*
* Ambos ciclos imprimen lo mismo, ya que la variable valor es local a cada bloque, y
* modificar su contenido no altera el contenido del arreglo. Si bien en cada ciclo la variable almacena
* una referencia a cada elemento del arreglo, actualizar su valor solamente modifica la referencia
* contenida por dicha variable, no las referencias del arreglo.
*
* */
package TPS.TP6.ej1;

import java.util.ArrayList;
import java.util.List;

public class Ej1 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList<Integer>();                     // PODRIA SER: List<Integer> list2 = new ArrayList<>();
        // List<Number> list3 = new ArrayList<Integer>();                      // Number != Integer
        List list4 = new ArrayList<Integer>();                              // BIEN PERO deberia ser asi: List<Integer> list4 = new ArrayList<>();
        // List<? extends Number> list5 = new ArrayList<? extends Number>();   // No compila, ya que el wildcard ? solo puede ser usado en el
                                                                            // tipo de una variable, no al instanciar una clase.
        List<?> list6 = new ArrayList();
    }
}
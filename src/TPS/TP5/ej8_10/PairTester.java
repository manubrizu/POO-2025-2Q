package TPS.TP5.ej8_10;

import java.util.Arrays;
import java.util.Comparator;

public class PairTester {
    public static void main(String[] args) {
        Pair<String, String> stringPair1 = new Pair<>("hola", "mundo");
        Pair<String, String> stringPair2 = new Pair<>("hola", "adiós");
        Pair<String, String> stringPair3 = new Pair<>("buen", "día");

        Pair pairArray[] = new Pair[]{stringPair1, stringPair2, stringPair3};

        Arrays.sort(pairArray, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int aDiff = o2.getA().compareTo(o1.getA());
                if(aDiff != 0) {
                    return aDiff;
                }
                return o2.getB().compareTo(o1.getB());
            }
        });
        System.out.println(Arrays.toString(pairArray));
    }

}

package TPS.TP2.ej7;

import java.util.Vector;

public class Histograma {
    public static void main(String[] args) {
        int[] vec = new int[10];
        int max = 0;
        for (String arg: args){
            int i = Integer.valueOf(arg) / 10;
            if(i < 0 || i >= 10){
                System.out.println("MAL");
            }
            vec[i]++;
            if(vec[i] > max) {
                max = vec[i];
            }
        }
        imprimirHist(vec, max);
    }

    private static void imprimirHist(int[] vec, int max){
        for (int i = max; i > 0; i--) {
            System.out.print("| ");
            for (int aFrec : vec) {
                System.out.print(aFrec >= i ? '*' : ' ');
                System.out.print(" | ");
            }
            System.out.println();
        }
        for (int aFrec : vec) {
            System.out.print("+---");
        }
        System.out.print("+\n");
        for (int i = 0; i <= vec.length; i++) {
            System.out.printf("%-4d", i*10);
        }
    }
}

package PARCIALES.P20232C.ej3;

import java.util.Arrays;
import java.util.Comparator;

public class MinToMaxReport<R> implements ReportCollection<R>{
    private R[] vec;
    private int dim;
    private static int BLOCK = 10;
    private final Comparator<? super R> cmp;

    @SuppressWarnings("unchecked")
    MinToMaxReport(Comparator<? super R> cmp){
        vec = (R[]) new Object[BLOCK];
        this.cmp = cmp;
    }

    @Override
    public void add(R report) {
        if(vec.length == dim) {
            resize();
        }
        vec[dim++] = report;
    }

    private void resize() {
        vec = Arrays.copyOf(vec, dim + BLOCK);
    }

    @Override
    public R get(int index) {
        if(index < 0 || index == dim) {
            throw new IllegalArgumentException();
        }
        return vec[index];
    }

    @Override
    public R[] reports() {
        R[] aux = Arrays.copyOf(vec, dim);
        Arrays.sort(aux, cmp);
        return aux;
    }
}

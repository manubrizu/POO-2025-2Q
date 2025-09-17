package PARCIALES.P20232C.ej3;

import java.util.Comparator;

public class MaxToMinReport<R> extends MinToMaxReport<R>{

    @SuppressWarnings("unchecked")
    MaxToMinReport(Comparator<? super R> cmp){
        super(cmp.reversed());
    }
}

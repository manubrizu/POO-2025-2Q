package PARCIALES.P2.P220241C.ej2;

import java.time.YearMonth;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Client {
    private SortedMap<YearMonth, Integer> reintegros = new TreeMap<>();
    private String nombre;
    private int topeMensual;

    Client(String nombre, int topeMensual){
        this.nombre = nombre;
        this.topeMensual = topeMensual;
    }

    public Map<YearMonth, Integer> rangos(YearMonth from, YearMonth to){
        return reintegros.subMap(from, to);
    }

    public void addReimbursement(YearMonth date, int amount) {
        int acumulado = reintegros.getOrDefault(date, 0);
        if (acumulado + amount > topeMensual) {
            throw new IllegalStateException("Reimbursement surpasses month cap.");
        }
        reintegros.put(date, acumulado + amount);
    }

    public int remaining(YearMonth date){
        return this.topeMensual - reintegros.getOrDefault(date, 0);
    }
}

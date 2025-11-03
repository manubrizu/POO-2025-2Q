package PARCIALES.P2.P220241C.ej2;

import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReimbursementTracker {
    private Map<String, Client> clientes = new HashMap<>();

    public void registerClient(String client, int topeMensual){
        if(clientes.containsKey(client)){
            throw new IllegalArgumentException("Client already registered.");
        }
        clientes.put(client, new Client(client, topeMensual));
    }

    private Client getClient(String nombre){
        Client c = clientes.get(nombre);
        if (c == null) throw new IllegalArgumentException("Client is not registered.");
        return c;
    }

    public Set<Map.Entry<YearMonth, Integer>> getReimbursements(String nombre, YearMonth from, YearMonth to){
        return getClient(nombre).rangos(from, to).entrySet();
    }

    public void addReimbursement(String nombre, YearMonth date, int monto){
        getClient(nombre).addReimbursement(date, monto);
    }

    public int getRemainingReimbursement(String nombre, YearMonth ym) {
        return getClient(nombre).remaining(ym);
    }
}

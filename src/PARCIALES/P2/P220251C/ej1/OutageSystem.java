package PARCIALES.P2.P220251C.ej1;

import java.util.*;

public class OutageSystem {
    private Map<String, Map<String, List<OutageReport>>> reports = new TreeMap<>();

    public void addSubstation(String barrio, String codigo){
        reports.putIfAbsent(barrio, new TreeMap<>(Comparator.reverseOrder()));
        reports.get(barrio).putIfAbsent(codigo, new ArrayList<>());
    }

    public Set<String> neighborhoods(){
        return reports.keySet();
    }

    public Set<String> subStations(String barrio){
        return reports.getOrDefault(barrio, new TreeMap<>()).keySet();
    }

    public void reportOutage(String barrio, String codigo, OutageReport report){
        if( ! reports.containsKey(barrio) || ! reports.get(barrio).containsKey(codigo) ){
            throw new NoSuchElementException();
        }
        reports.get(barrio).get(codigo).add(report);
    }


}

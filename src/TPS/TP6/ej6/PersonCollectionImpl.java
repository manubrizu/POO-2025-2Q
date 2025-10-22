package TPS.TP6.ej6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonCollectionImpl implements PersonCollection{
    private Map<String, Map<String, Person>> map = new HashMap<>(); // ES UN MAPA QUE ORDENA POR APELLIDO Y DSP POR NOMBRE


//    @Override
//    public void addPerson(Person p) {
//        if(!map.containsKey(p.getLastName())) {         // SI EL APELLIDO NO EXISTIA, CREO UN NUEVO MAPA DE NOMBRES EN ESE APELLIDO
//            map.put(p.getLastName(), new HashMap<>());
//        }
//        map.get(p.getLastName()).put(p.getFirstName(), p);
//    }

    @Override
    public void addPerson(Person p) {
        map.putIfAbsent(p.getLastName(), new HashMap<>());
        map.get(p.getLastName()).put(p.getFirstName(), p);
    }


//    @Override
//    public List<Person> findByLastName(String lastName) {
//        if(!map.containsKey(lastName)){
//            return new ArrayList<>(); // LISTA VACIA SI NO HAY CON ESE APELLIDO
//        }
//        return new ArrayList<>(map.get(lastName).values());
//    }

    // SE PODIA HACER CON GET OR DEFAULT MAS FACIL
    @Override
    public List<Person> findByLastName(String lastName) {
        return new ArrayList<>(map.getOrDefault(lastName, new HashMap<>()).values());
    }

//    @Override
//    public Person findByName(String firstName, String lastName) {
//        if(!map.containsKey(lastName)){
//            return null;
//        }
//        return map.get(lastName).get(firstName);
//    }

    @Override
    public Person findByName(String firstName, String lastName) {
        return map.getOrDefault(lastName, new HashMap<>()).get(firstName);
    }
}

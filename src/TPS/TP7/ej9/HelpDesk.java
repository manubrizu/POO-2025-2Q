package TPS.TP7.ej9;

import java.util.*;

public class HelpDesk {
    // Usamos EnumMap porque las claves son de tipo enum (ClientType):
    // - Implementación muy eficiente en memoria y velocidad para enums
    // - No acepta claves null
    // - Mantiene el orden natural del enum (ordinal) al iterar
    private Map<ClientType, Queue<HelpTicket>> queuesByClient = new EnumMap<>(ClientType.class);

    public HelpDesk openTicket(ClientType type, String name, String ticket){
        // Map.putIfAbsent(k, v): solo inserta si la clave no existe aún (evita pisar una cola existente)
        queuesByClient.putIfAbsent(type, new LinkedList<>());
        // Queue.offer(e): agrega al final; devuelve false si no se pudo (a diferencia de add que lanza excepción)
        queuesByClient.get(type).offer(new HelpTicket(name, ticket));
        return this;
    }

    public HelpTicket getNextTicket(ClientType type){
        // Map.getOrDefault(k, def): si no existe la clave, devuelve 'def' sin insertarla en el mapa
        // Queue.remove(): obtiene y remueve el primero; lanza NoSuchElementException si está vacío
        // Nota: si 'type' no existe, usamos una LinkedList vacía y remove() lanzará NoSuchElementException
        return queuesByClient.getOrDefault(type, new LinkedList<>()).remove();
    }

    public HelpTicket getNextTicket(){
        // Map.values(): vista de las colecciones (colas) almacenadas como valores en el mapa
        for(Queue<HelpTicket> foo : queuesByClient.values()){
            if(!foo.isEmpty()){
                // Queue.poll(): obtiene y remueve el primero; devuelve null si la cola está vacía (no lanza excepción)
                return foo.poll();
            }
        }
        throw new NoSuchElementException();
    }

    public boolean hasTickets(){
        for(Queue<HelpTicket> foo : queuesByClient.values()){
            // Queue.isEmpty(): chequea si hay elementos en la cola
            if(! foo.isEmpty()){
                return true;
            }
        }
        return false;
    }

    static class HelpTicket {
        private String name, ticket;

        public HelpTicket(String name, String ticket) {
            this.name = name;
            this.ticket = ticket;
        }

        @Override
        public String toString(){
            return "HelpTicket for %s asking %s".formatted(name, ticket);
        }
    }
}

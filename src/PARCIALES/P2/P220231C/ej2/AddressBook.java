package PARCIALES.P2.P220231C.ej2;

import java.util.*;

public class AddressBook {
    private Map<AddressBookGroup, SortedMap<String, Contact>> map = new TreeMap<>();

    public void addContact(AddressBookGroup group, String contactName, String phone){
        Contact c = new Contact(contactName, phone);
        map.putIfAbsent(group, new TreeMap<>());
        map.get(group).put(contactName, c);
    }

    public Contact getContact(AddressBookGroup group, String contactName){
        if(!map.containsKey(group) || ! map.get(group).containsKey(contactName)){
            throw new IllegalArgumentException();
        }
        return map.get(group).get(contactName);
    }

    public Collection<Contact> getAllContacts(AddressBookGroup group){
        return map.getOrDefault(group, new TreeMap<>()).values();
    }

    public List<Contact> getAllContacts(){
        List<Contact> toReturn = new ArrayList<>();
        for (AddressBookGroup group : map.keySet()){
            toReturn.addAll(getAllContacts(group));
        }
        return toReturn;
    }

    public void renameContact(AddressBookGroup group, String oldName, String newName){
        if(!map.containsKey(group) || ! map.get(group).containsKey(oldName)){
            throw new IllegalArgumentException();
        }
        Contact newC = map.get(group).remove(oldName);
        newC.setName(newName);
        addContact(group, newName, newC.getPhoneNumber());
    }

}

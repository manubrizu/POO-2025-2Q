package PARCIALES.P2.P220231C.ej2;

public class AddressBookGroup implements Comparable<AddressBookGroup> {
    private final String name;

    public AddressBookGroup(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(AddressBookGroup o){
        return name.compareTo(o.name);
    }
}

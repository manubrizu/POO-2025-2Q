package TPS.TP7.ej7;

public class MyComparableClass implements Comparable<MyComparableClass>{
    private String identifier;
    public String sortableIdentifier;

    MyComparableClass(String identifier){
        if(identifier == null){
            throw new IllegalArgumentException();
        }
        this.identifier = identifier;
    }

    @Override
    public int compareTo(MyComparableClass o) {
        return sortableIdentifier.compareTo(o.sortableIdentifier);
    }

    @Override
    public String toString(){
        return identifier + " - " + "(" + sortableIdentifier + ")";
    }
}

package TALLER.taller6;

public interface List<T>{
    void add(T element);

    int getIndex(T element);

    boolean remove(int index);

    boolean isEmpty();

    default boolean removeElement(T element){
        int index = this.getIndex(element);
        if (!isEmpty()){
            return remove(index);
        }
        return false;
    }


}

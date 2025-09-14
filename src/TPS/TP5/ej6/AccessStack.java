package TPS.TP5.ej6;

public interface AccessStack<E> extends Stack<E> {
    int getPopAccesses();
    int getPushAccesses();
}

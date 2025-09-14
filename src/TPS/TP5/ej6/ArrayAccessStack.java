package TPS.TP5.ej6;

public class ArrayAccessStack<E> extends ArrayStack<E> implements AccessStack<E> {

    private int popAccesses;

    public ArrayAccessStack() {
        super();
    }
    @Override
    public E pop() {
        E toReturn = super.pop();
        this.popAccesses++;
        return toReturn;
    }

    @Override
    public int getPopAccesses() {
        return this.popAccesses;
    }

    @Override
    public int getPushAccesses() {
        return getDim() + this.popAccesses;
    }

}

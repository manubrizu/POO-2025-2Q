package TPS.TP6.ej3;

public class Pair<E> {
    private final E l, r;
    
    Pair(E l, E r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public String toString() {
        return "# %s + %s #".formatted(l, r);
    }
}

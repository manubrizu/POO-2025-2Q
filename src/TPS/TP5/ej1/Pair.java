package TPS.TP5.ej1;

import java.util.Objects;

public class Pair<A, B> {
    private A a;
    private B b;

    Pair(A a, B b){
        this.a = a;
        this.b = b;
    }

    //  GETTERS
    public A getA() {
        return a;
    }
    public B getB() {
        return b;
    }

    //  SETTERS
    public void setA(A a) {
        this.a = a;
    }
    public void setB(B b) {
        this.b = b;
    }

    public String toString(){
        return "[%s, %s]".formatted(a, b);
    }

    public boolean equals(Object o){
        return o instanceof Pair<?,?> pair && a.equals(pair.a) && b.equals(pair.b);
        //  el casteo realizado automáticamente
        //  por el pattern matching instanceof utiliza el operador wildcard para cada uno de los tipos genéricos
        //  de la clase
    }

    public int hashCode(){
        return Objects.hash(a, b);
    }
}

package TALLER.taller1;

public class Main {
    public static void main(String[] args) {
        Counter c = new Counter();
        c.increment();
        c.increment();
        c.decrement();
        System.out.println(c.getCount());

        Counter c2 = new MultipleCounter(2);
        c2.increment();
        c2.increment();
        c2.decrement();
        System.out.println(c.getCount());
    }
}

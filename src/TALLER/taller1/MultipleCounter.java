package TALLER.taller1;

public class MultipleCounter extends Counter{
    private int incrementador;

    public MultipleCounter(int incrementador) {
        super();
        this.incrementador = incrementador;
    }

    @Override
    public void increment(){
        for (int i = 0; i<this.incrementador; i++){
            super.increment();
        }
    }

    @Override
    public void decrement(){
        for (int i = 0; i<this.incrementador; i++){
            super.decrement();
        }
    }
}

package TALLER.taller1;

public class Counter{
    protected int count;
    public Counter(){
        this.count = 0;
    }
    public void increment(){
        this.count++;
    }

    public void decrement(){
        this.count--;
    }

    public int getCount(){
        return this.count;
    }
}

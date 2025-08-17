package TP1.ej6;

public class Amount {
    private double value;

    public double getValue(){
        return this.value;
    }

    public int getEntirePart(){
        return Math.abs(this.value);
    }

}

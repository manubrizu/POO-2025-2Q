package TPS.TP3.ej6;

import java.util.Objects;

public class ComplexNumber {
    private double real;
    private double imag;

    public ComplexNumber(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    public ComplexNumber(Number real){
        this(real.doubleValue(),0);
    }

    public double getReal(){
        return real;
    }

    public double getImag(){
        return imag;
    }

    public ComplexNumber plus(ComplexNumber z){     // no usar add por convencion
        return new ComplexNumber(this.real+z.getReal(), this.imag+z.getImag());
    }

    public ComplexNumber plus(Number n){
        return plus(new ComplexNumber(n));
    }

    @Override
    public String toString() {
        return "%.2f %c %.2f".formatted(real, imag > 0 ? '+' : '-', Math.abs(imag));
    }

    @Override
    public boolean equals(Object o){
        return o instanceof ComplexNumber c &&
                Double.compare(c.getReal(), real) == 0 &&
                Double.compare(c.getImag(), imag) == 0;
    }

    @Override
    public int hashCode(){
        return Objects.hash(real, imag);
    }
}

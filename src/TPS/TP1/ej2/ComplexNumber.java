package TPS.TP1.ej2;

public class ComplexNumber {
    private int real;
    private int imag;

    public ComplexNumber(int real, int imag){
        this.real = real;
        this.imag = imag;
    }

    public ComplexNumber(int real){
        this.real = real;
        this.imag = 0;
    }

    public int getReal(){
        return real;
    }

    public int getImag(){
        return imag;
    }

    public ComplexNumber plus(ComplexNumber z){     // no usar add por convencion
        return new ComplexNumber(this.real+z.getReal(), this.imag+z.getImag());
    }
}

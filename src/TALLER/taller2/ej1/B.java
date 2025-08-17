package TALLER.taller2.ej1;

public class B extends A{
    public int m1(){
        return m2();
    }

    public int m2(){
        return 2;
    }

    public int m3(){
        return super.m2();
    }
}

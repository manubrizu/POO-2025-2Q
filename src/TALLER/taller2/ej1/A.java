package TALLER.taller2.ej1;

public class A {
    int m1(){
        return 1;
    }

    int m2(){
        return m1();
    }

    int m3(){
        return this.m1();
    }
}

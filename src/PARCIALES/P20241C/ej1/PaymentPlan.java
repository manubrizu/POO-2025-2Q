package PARCIALES.P20241C.ej1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PaymentPlan implements Iterator<PaymentDetail> {
    private Plan plan;
    private int cuotasTotales;
    private double amountCuota;
    private int cuotaActual;

    PaymentPlan(Plan plan, double totalAmount, int cuotas){
        if(cuotas < plan.getCuotas() || totalAmount <= 0) {
            throw new InvalidPaymentPlanException();
        }
        this.plan = plan;
        this.amountCuota = totalAmount / cuotas;
        this.cuotaActual = 1;
    }

    @Override
    public boolean hasNext(){
        return cuotaActual <= cuotasTotales;
    }

    @Override
    public PaymentDetail next(){
        if(!hasNext()){
            throw new NoSuchElementException("hola");
        }
        PaymentDetail aux = peek();
        cuotaActual++;
        return aux;
    }

    public PaymentDetail peek(){
        if(!hasNext()){
            throw new NoSuchElementException("puto");
        }
        return new PaymentDetail(cuotaActual, plan.apply(amountCuota, cuotaActual));
    }

}

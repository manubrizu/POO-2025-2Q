package PARCIALES.P1C2025.ej1;

import java.time.MonthDay;

public class SavingsAccount {
    protected double saldo;
    protected double INTEREST = 0.3 * (1.0 / 365);
    protected MonthDay openDate;

    SavingsAccount(MonthDay openDate){
        this.openDate = openDate;
        this.saldo = 0;
    }

    public void depositFunds(double deposit, MonthDay depositDate){
        if(deposit < 0 || depositDate.isBefore(openDate)){
            throw new IllegalArgumentException("puto");
        }
        this.saldo += deposit;
    }

    public double getBalance(){
        return this.saldo;
    }

    public void interestPayment(int days){
        for (int i = 0; i < days; i++){
            this.saldo += this.saldo * INTEREST;
        }
    }

    public void withdrawFunds(double extractAmount, MonthDay extractDate){
        if(extractAmount < 0 || extractDate.isBefore(openDate)){
            throw new IllegalArgumentException("puto");
        }
        this.saldo -= extractAmount;
    }

}

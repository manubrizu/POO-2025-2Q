package PARCIALES.P1C2025.ej1;

import java.time.MonthDay;

public class SavingsAccountC extends SavingsAccountB{
    private int MAX_INTEREST = 1_000_000;

    SavingsAccountC(MonthDay openDate){
        super(openDate);
    }

    @Override
    public void depositFunds(double deposit, MonthDay depositDate){
        if(deposit < 100_000 || depositDate.isBefore(openDate)){
            throw new IllegalArgumentException("puto");
        }
        this.saldo += deposit;
    }

    @Override
    public void interestPayment(int days){
        for (int i = 0; i < days; i++) {
            double saldoParaInteres = Math.min(saldo, MAX_INTEREST);
            this.saldo += saldoParaInteres * INTEREST;
        }
    }
}

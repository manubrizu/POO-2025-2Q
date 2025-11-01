package PARCIALES.P1.P20251C.ej1;

import java.time.MonthDay;

public class SavingsAccountB extends SavingsAccount {
    protected MonthDay lastExtractDate;

    SavingsAccountB(MonthDay openDate){
        super(openDate);
        this.lastExtractDate = openDate;
    }

    @Override
    public void withdrawFunds(double extractAmount, MonthDay extractDate){
        if(extractAmount < 0 || extractDate.isBefore(openDate) || extractDate.isBefore(lastExtractDate)){
            throw new IllegalArgumentException("puto");
        }
        this.lastExtractDate = extractDate;
        this.saldo -= extractAmount;
    }

}

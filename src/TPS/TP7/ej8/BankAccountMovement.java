package TPS.TP7.ej8;

public class BankAccountMovement {
    private BankAccountMovementType type;
    private double balance;

    BankAccountMovement(BankAccountMovementType type, double balance){
        this.balance = balance;
        this.type = type;
    }

    public double getBalance(){
        return this.balance;
    }

    @Override
    public String toString(){
        return "%s $%.2f".formatted(type, Math.abs(balance));
    }
}

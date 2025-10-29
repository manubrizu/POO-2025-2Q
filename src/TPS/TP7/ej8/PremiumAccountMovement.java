package TPS.TP7.ej8;

public class PremiumAccountMovement extends BankAccountMovement{
    private String name;

    PremiumAccountMovement(BankAccountMovementType type, double balance, String name){
        super(type, balance);
        this.name = name;
    }

    @Override
    public String toString(){
        return "%s for shop %s".formatted(super.toString(), name);
    }
}

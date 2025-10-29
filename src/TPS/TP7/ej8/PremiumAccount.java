package TPS.TP7.ej8;

public class PremiumAccount extends CheckingAccount{
    private ShopDiscountsProvider provider;

    PremiumAccount(int id, double overdraft, ShopDiscountsProvider provider){
        super(id, overdraft);
        this.provider = provider;
    }

    public double extract(double amount, String name){
        return super.extract( new PremiumAccountMovement(BankAccountMovementType.EXTRACTION, amount * (1 - provider.getDiscount(name)), name));
    }
}

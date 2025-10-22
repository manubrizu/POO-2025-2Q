package TPS.TP6.ej4;

public class SavingsAccount extends BankAccount {

    SavingsAccount(int id) {
        super(id);
    }

    @Override
    protected boolean canExtract(double amount) {
        return super.getBalance() >= amount;
    }

}

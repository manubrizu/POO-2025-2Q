package TPS.TP3.ej7;

public class CheckingAccount extends BankAccount {
    private double overdraft;

    CheckingAccount(int id, double overdraft) {
        super(id);
        this.overdraft = overdraft;
    }

    @Override
    protected boolean canExtract(double amount) {
        return super.getBalance() + this.overdraft >= amount;
    }

    public double getOverdraft() {
        return this.overdraft;
    }
}

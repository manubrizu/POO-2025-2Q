package TPS.TP3.ej7;

public abstract class BankAccount {
    private int id;
    private double balance;

    BankAccount(int id) {
        this.id = id;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double extract(double amount) {
        if(canExtract(amount)) {
            return balance -= amount;
        }
        return balance;
    }

    protected abstract boolean canExtract(double amount);

    public double getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return "Cuenta %d con saldo %.2f".formatted(id, balance);
    }
}

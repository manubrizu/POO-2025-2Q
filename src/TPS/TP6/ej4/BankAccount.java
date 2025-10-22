package TPS.TP6.ej4;

import java.util.Objects;

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

    // Esto ocurre porque el método remove
    //  de ArrayList invoca al método equals, el cual no fue sobreescrito en la clase BankAccount
    @Override
    public boolean equals(Object o) {
        return o instanceof BankAccount that &&
                id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

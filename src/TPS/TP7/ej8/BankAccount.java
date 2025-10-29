package TPS.TP7.ej8;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

public abstract class BankAccount {
    private int id;
    private final List<BankAccountMovement> movements;
    private double balance;

    BankAccount(int id) {
        this.id = id;
        this.movements = new ArrayList<>();
    }

    public void deposit(double amount) {
        movements.add(new BankAccountMovement(BankAccountMovementType.DEPOSIT, amount));
        this.balance += amount;
    }

    public double extract(double amount) {
        return extract(new BankAccountMovement(BankAccountMovementType.EXTRACTION, - amount));
    }

    protected double extract(BankAccountMovement move){
        if(! canExtract(move.getBalance())){
            throw new IllegalArgumentException("No cuenta con los fondos necesarios");
        }

        movements.add(move);
        return balance -= move.getBalance();
    }

    protected abstract boolean canExtract(double amount);

    public double getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return "Cuenta %d con saldo %.2f".formatted(id, balance);
    }

    public void showMovements(){
        System.out.println("Movements for Account " + id);
        for (BankAccountMovement foo : movements){
            System.out.println(foo);
        }
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

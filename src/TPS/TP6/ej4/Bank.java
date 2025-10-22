package TPS.TP6.ej4;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount acc) {
        accounts.add(acc);
    }

    public void removeAccount(BankAccount acc) {
        accounts.remove(acc);
    }

    public int accountSize(){
        return accounts.size();
    }

    public double totalAmount() {
        double totalAmount = 0;
        for(BankAccount account : accounts) {
            totalAmount += account.getBalance();
        }
        return totalAmount;
    }
}

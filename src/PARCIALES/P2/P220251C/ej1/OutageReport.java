package PARCIALES.P2.P220251C.ej1;

public class OutageReport {
    private final int accountNumber;
    private final String accountHolder;

    public OutageReport(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }

    @Override
    public String toString() {
        return "Outage reported by %s (Account %s)".formatted(accountHolder, accountNumber);
    }
}
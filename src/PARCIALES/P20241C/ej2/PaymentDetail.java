package PARCIALES.P20241C.ej1;

public class PaymentDetail {
    private final int installment;
    private final double installmentAmount;

    public PaymentDetail(int installment, double installmentAmount) {
        this.installment = installment;
        this.installmentAmount = installmentAmount;
    }

    @Override
    public String toString() {
        return "$%.2f due for installment %d".formatted(installmentAmount, installment);
    }
}

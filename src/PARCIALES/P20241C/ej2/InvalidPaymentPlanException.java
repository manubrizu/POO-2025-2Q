package PARCIALES.P20241C.ej1;

public class InvalidPaymentPlanException extends RuntimeException{
    private static final String MESSAGE = "Invalid payment plan";
    public InvalidPaymentPlanException() {
        super(MESSAGE);
    }
}

package TPS.TP7.ej8;

public enum BankAccountMovementType {
    EXTRACTION("Extraction"),
    DEPOSIT("Deposit");

    private String description;

    BankAccountMovementType(String description){
        this.description = description;
    }

    @Override
    public String toString(){
        return description;
    }
}

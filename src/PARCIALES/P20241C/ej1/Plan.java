package PARCIALES.P20241C.ej1;

public enum Plan {
    DOCE_CUOTAS(12){
        @Override
        public double apply(double installmentAmount, int installment) {
            return installmentAmount;
        }

    },
    VENTICUATRO_CUOTAS(24){
        @Override
        public double apply(double installmentAmount, int installment) {
            if(installment == 3) {
                return 0;
            }
            return installmentAmount;
        }
    },
    FULL_CUOTAS(365){
        @Override
        public double apply(double installmentAmount, int installment) {
            if(installment % 2 == 0) {
                return installmentAmount / 2;
            }
            return installmentAmount;
        }
    };

    private int maxCuotas;
    private int cuotasGratis;

    Plan(int maxCuotas) {
        this.maxCuotas = maxCuotas;
    }
    public boolean isValid(int cuotas) {
        return cuotas <= maxCuotas;
    }
    public abstract double apply(double installmentAmount, int installment);


}

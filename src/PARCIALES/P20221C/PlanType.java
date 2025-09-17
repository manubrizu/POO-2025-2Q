package PARCIALES.P20221C;

public enum PlanType {
    PLAN_MIL(1_000, 950){
        @Override
        public int apply(int miles, int month){
            return miles;
        }
    },
    PLAN_2MIL(2_000, 1750){
        @Override
        public int apply(int miles, int month){
            if(month <= 2){
                return miles + 1000;
            }
            return miles;
        }
    },
    PLAN_5MIL(5_000, 4400){
        @Override
        public int apply(int miles, int month){
            if(month <= 5){
                return miles + 2500;
            }
            return miles;
        }
    },
    PLAN_FULL(10_000, 14400){
        @Override
        public int apply(int miles, int month){
            if(month <= 6){
                return miles + 10000;
            }
            return miles;
        }
    };

    private int miles;
    private double cost;

    PlanType(int miles, double cost){
        this.miles = miles;
        this.cost = cost;
    }

    public int getMiles(int currentMonth) {
        return apply(this.miles, currentMonth);
    }

    public double getCost(){
        return this.cost;
    }

    public abstract int apply(int miles, int month);
}

package TALLER.taller3;

public class DiscountRechargeableSubwayCard extends RechargeableSubwayCard {
    private double discountPercentage;

    DiscountRechargeableSubwayCard(SubwayCentral cs, double discountPercentage) {
        super(cs);
        this.discountPercentage = discountPercentage;
    }

    @Override
    protected double rideCost(){
        return super.rideCost() * this.discountPercentage;
    }
}

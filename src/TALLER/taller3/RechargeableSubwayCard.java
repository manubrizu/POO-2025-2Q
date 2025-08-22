package TALLER.taller3;

public class RechargeableSubwayCard extends SubwayCard{
    private double balance;

    RechargeableSubwayCard(SubwayCentral sc){
        super(sc);
    }

    public void recharge(double amount){
        this.balance += amount;
    }

    protected double rideCost(){
        return super.getSubwayCentral().getRideCost();
    }

    @Override
    protected boolean canRide(){
        return !(this.balance < this.rideCost());
    }

    @Override
    public void ride() throws CannotRideException {
        if(this.canRide()){
            this.balance -= this.rideCost();
        }
        else{
            throw new CannotRideException("Nao nao");
        }
    }
}


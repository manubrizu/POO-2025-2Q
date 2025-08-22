package TALLER.taller3;

public class SubwayCardTester {

    public static void main(String[] args) {
        SubwayCentral sc = new SubwayCentral(25);

        FixedSubwayCard fsc = new FixedSubwayCard(sc, 2);
        try{
            fsc.ride();
            fsc.ride();
            fsc.ride(); // Imprime un mensaje de error
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }


        RechargeableSubwayCard rsc = new RechargeableSubwayCard(sc);
        rsc.recharge(50);
        try{
            rsc.ride();
            sc.setRideCost(30);
            rsc.ride(); // Imprime un mensaje de error
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


        DiscountRechargeableSubwayCard drsc = new DiscountRechargeableSubwayCard(sc, 0.50);
        drsc.recharge(30);

        try{
            drsc.ride();
            drsc.ride();
            drsc.ride(); // Imprime un mensaje de error}
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}

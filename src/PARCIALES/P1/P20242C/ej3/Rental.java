package PARCIALES.P1.P20242C.ej3;

import java.time.LocalDate;

public class Rental {
    private String location;
    private LocalDate rentalDate;
    private int kms;

    Rental(String location, LocalDate rentalDate){
        this.location = location;
        this.rentalDate = rentalDate;
        this.kms = 0;
    }


}

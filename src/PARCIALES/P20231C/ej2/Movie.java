package PARCIALES.P20231C.ej2;

import java.time.LocalDate;

public class Movie {
    private final String title;
    private final LocalDate airedDate;
    private final String studio;


    public Movie(String title, LocalDate airedDate, String studio) {
        this.title = title;
        this.airedDate = airedDate;
        this.studio = studio;
    }
}


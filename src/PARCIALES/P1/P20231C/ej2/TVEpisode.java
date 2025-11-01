package PARCIALES.P1.P20231C.ej2;

import java.time.LocalDate;

public class TVEpisode {
    private final String title;
    private final LocalDate airedDate;
    private final int season;


    public TVEpisode(String title, LocalDate airedDate, int season) {
        this.title = title;
        this.airedDate = airedDate;
        this.season = season;
    }
}


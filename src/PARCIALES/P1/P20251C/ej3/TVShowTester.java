package PARCIALES.P1.P20251C.ej3;

import java.util.Iterator;

public class TVShowTester {
    public static void main(String[] args) {
        // Se instancia un programa de TV de 2 temporadas, donde cada una tiene 3 episodios
        TVShow sherlock = new TVShow(2, 3);

        for (TVEpisode episode : sherlock) { // Se consultan los 6 episodios de la serie
            System.out.printf("%s # ", episode);
        }
        System.out.println();
        /// [S01E01] # [S01E02] # [S01E03] # [S02E01] # [S02E02] # [S02E03] #

        Iterator<TVEpisode> sherlockIt = sherlock.iterator();
        sherlock.setSeasons(1);            // Se modifica la cantidad de temporadas a 1
        sherlock.setEpisodesPerSeason(2);  // Se modifica la cantidad de episodios a 2
        System.out.println(sherlockIt.next()); /// [S01E01]

        while (sherlockIt.hasNext()) { // Se consultan los 6 episodios de la serie
            System.out.printf("%s # ", sherlockIt.next());
        }
        System.out.println();
        /// [S01E01] # [S01E02] # [S01E03] # [S02E01] # [S02E02] # [S02E03] #

        for (TVEpisode episode : sherlock) { // Se consultan los 2 episodios de la serie
            System.out.printf("%s # ", episode);
        }
        System.out.println();
        /// [S01E01] # [S01E02] #

        try {
            sherlock.setEpisodesPerSeason(0);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            // La cantidad de episodios debe ser positiva.
        }
    }
}

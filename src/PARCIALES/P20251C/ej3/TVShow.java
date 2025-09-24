package PARCIALES.P20251C.ej3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TVShow implements Iterable<TVEpisode> {
    private int seasons, episodes;

    TVShow(int seasons, int episodes){
        setSeasons(seasons);
        setEpisodesPerSeason(episodes);
    }

    public void setSeasons(int seasons){
        if(seasons < 1){
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
        this.seasons = seasons;
    }

    public void setEpisodesPerSeason(int episodes){
        if(episodes < 1){
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
        this.episodes = episodes;
    }

    public Iterator<TVEpisode> iterator(){
        return new TVShowIterator();
    }

    public class TVShowIterator implements Iterator<TVEpisode>{
        private int currentSeason = 1, currentEpisode = 1;
        private int seasonsIt = seasons, episodesIt = episodes;

        @Override
        public boolean hasNext(){
            return currentSeason <= seasonsIt;
        }

        @Override
        public TVEpisode next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            TVEpisode aux = new TVEpisode(currentSeason, currentEpisode);
            if(currentEpisode == episodesIt){
                currentSeason++;
                currentEpisode = 1;
            }
            else{
                currentEpisode++;
            }
            return aux;
        }
    }

}

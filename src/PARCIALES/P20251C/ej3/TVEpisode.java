package PARCIALES.P20251C.ej3;

public class TVEpisode {
    private int season, episode;

    public TVEpisode(int season, int episode) {
        this.season = season;
        this.episode = episode;
    }

    @Override
    public String toString(){
        return "[S%02dE%02d]".formatted(season, episode);
    }
}

package PARCIALES.P20242C.ej2;

public class Article implements Comparable<Article> {
    private String titulo;
    private FeedType feedType;
    private boolean leido;
    
    public Article(FeedType feedType, String titulo) {
        this.feedType = feedType;
        this.titulo = titulo;
        this.leido = true;
    }
    
    @Override
    public String toString() {
        return "%s %s is %s".formatted(feedType, titulo, leido ? "unread" : "read");
    }

    public void read() {
        leido = false;
    }
    
    public FeedType getFeedType() {
        return feedType;
    }
    
    public boolean isUnread() {
        return leido;
    }
    
    @Override
    public int compareTo(Article o) {
        int cmp = feedType.compareTo(o.feedType);
        if(cmp == 0) {
            cmp = titulo.compareTo(o.titulo);
        }
        return cmp;
    }
}
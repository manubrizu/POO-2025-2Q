package PARCIALES.P1.P20242C.ej2;

public class Article implements Comparable<Article> {
    private String titulo;
    private FeedType feedType;
    private boolean leido;
    
    public Article(FeedType feedType, String titulo) {
        this.feedType = feedType;
        this.titulo = titulo;
        this.leido = false;
    }
    
    @Override
    public String toString() {
        return "%s %s is %s".formatted(feedType, titulo, leido ? "read" : "unread");
    }

    public void read() {
        leido = true;
    }
    
    public FeedType getFeedType() {
        return feedType;
    }
    
    public boolean isUnread() {
        return !leido;
    }
    
    @Override
    public int compareTo(Article a) {               ///  ORDEN NATURAL
        int cmp = feedType.compareTo(a.feedType);
        if(cmp == 0) {
            cmp = titulo.compareTo(a.titulo);
        }
        return cmp;
    }
}
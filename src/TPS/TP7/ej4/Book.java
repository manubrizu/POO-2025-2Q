package TPS.TP7.ej4;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private String title, author;

    Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof Book b &&
                title.equals(b.title) && author.equals(b.author);
    }

    @Override
    public int hashCode(){
        return Objects.hash(title, author);
    }

    @Override
    public String toString(){
        return title;
    }

    @Override
    public int compareTo(Book o) {
        int cmp = title.compareTo(o.title);
        if(cmp == 0) {
            cmp = author.compareTo(o.author);
        }
        return cmp;
    }
}

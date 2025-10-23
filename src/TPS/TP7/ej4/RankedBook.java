package TPS.TP7.ej4;

public class RankedBook implements Comparable<RankedBook>{
    Book book;
    Genre genre;
    private int ranking;

    RankedBook(Book book, Genre genre){
        this.book = book;
        this.genre = genre;
    }

    RankedBook(Book book) {
        this.book = book;
        this.ranking = 1;
    }

    RankedBook(RankedBook rankedBook) {
        this.book = rankedBook.book;
        this.ranking = rankedBook.ranking + 1;
        this.genre = rankedBook.genre;
    }

    @Override
    public String toString() {
        return "%s : %d".formatted(book, ranking);
    }

    @Override
    public int compareTo(RankedBook o) {
        int cmp = Integer.compare(o.ranking, ranking);
        if(cmp == 0) {
            return book.compareTo(o.book);
        }
        return cmp;
    }
}

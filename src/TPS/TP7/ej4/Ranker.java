package TPS.TP7.ej4;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ranker {
    private Set<RankedBook> set = new TreeSet<>();

    public Ranker add(Genre genre, Book book){
        set.add(new RankedBook(book, genre));
        return this;
    }

    public void rateUp(Book b){
        boolean found = false;

        Iterator<RankedBook> it = set.iterator();
        while(it.hasNext() && !found){
            RankedBook rankedBook = it.next();
            if(rankedBook.book.equals(b)){
                it.remove();
                set.add(new RankedBook(rankedBook));    //
                found = true;
            }
        }
        if(!found){
            set.add(new RankedBook(b));
        }
    }

    public void printRanking() {
        System.out.println("General Ranking");
        for(RankedBook rankedBook : set) {
            System.out.println(rankedBook);
        }
    }

    public void printRanking(Genre genre) {
        System.out.println("Ranking of " + genre);
        for (RankedBook rankedBook : set) {
            if (genre.equals(rankedBook.genre)) {
                System.out.println(rankedBook);
            }
        }
    }
}

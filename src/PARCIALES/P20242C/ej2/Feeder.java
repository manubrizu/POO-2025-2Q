package PARCIALES.P20242C.ej2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class Feeder {
    private static final int BLOCK = 5;
    private Article[] articles;
    private int dim;
    
    public Article addArticle(FeedType feedType, String title) {
        if(dim == articles.length) {
            resize();
        }
        Article article = new Article(feedType, title);
        articles[dim++] = article;
        return article;
    }

    public Article firstUnread() {
        return firstUnread(fT -> true);
    }

    public Article firstUnread(FeedType feedType) {
        return firstUnread(fT -> fT.equals(feedType));
    }

    private Article firstUnread(Predicate<FeedType> feedTypePredicate) {
        for(int i = 0; i < dim; i++) {
            if(articles[i].isUnread() & feedTypePredicate.test(articles[i].getFeedType())) {
                return articles[i];
            }
        }
        throw new IllegalArgumentException();
    }

    private void resize() {
        articles = Arrays.copyOf(articles, dim + BLOCK);
    }

    public Article[] getArticlesCopy() {
        return getArticlesCopy(Comparator.naturalOrder());
    }

    public Article[] getReversedArticlesCopy() {
        return getArticlesCopy(Comparator.reverseOrder());
    }

    private Article[] getArticlesCopy(Comparator<Article> comparator) {
        Article[] toReturn = Arrays.copyOf(articles, dim);
        Arrays.sort(toReturn, comparator);
        return toReturn;
    }
}

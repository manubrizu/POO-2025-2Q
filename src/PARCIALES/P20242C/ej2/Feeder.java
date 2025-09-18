package PARCIALES.P20242C.ej2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class Feeder {
    private static final int BLOCK = 10;
    private Article[] articles;
    private int dim;

    Feeder() {
        articles = new Article[BLOCK];
    }
    
    public Article addArticle(FeedType feedType, String title) {
        if(dim == articles.length) {
            resize();
        }
        Article article = new Article(feedType, title);
        articles[dim++] = article;
        return article;
    }

    /// HAY 2 OPCIONES:
    ///                 ->) NO ME PASAN NADA Y TENGO QUE DEVOLVER EL PRIMERO QUE APAREZCA
    ///                 ->) ME PASAN EL TIPO DE ARTICULO Y TENGO QUE DEVOLVER EL PRIMERO QUE APAREZCA DE ESE TIPO

    public Article firstUnread() {
        return showUnread(fT -> true);      /// LE PASO UN PREDICATE TRUE
        ///  OTRA FORMA
//        return showUnread(new Predicate<FeedType>(){
//            @Override
//            public boolean test(FeedType fT) {
//                return true;
//            }
//        });
    }

    public Article firstUnread(FeedType feedType) {
        return showUnread(fT -> fT.equals(feedType));       /// LE PASO LA CONDICION QUE TIENE QUE CUMPLIR CON EL TIPO DE "feedType"
        ///  OTRA FORMA
//        return showUnread(new Predicate<FeedType>(){
//            @Override
//            public boolean test(FeedType fT) {
//                return feedType.equals(fT);
//            }
//        });
    }

    private Article showUnread(Predicate<FeedType> feedTypePredicate) {
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

    private Article[] getArticlesCopy(Comparator<Article> cmp) {
        Article[] toReturn = Arrays.copyOf(articles, dim);
        Arrays.sort(toReturn, cmp);
        return toReturn;
    }
}

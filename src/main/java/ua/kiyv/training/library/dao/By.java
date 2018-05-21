package ua.kiyv.training.library.dao;


import static ua.kiyv.training.library.dao.Impl.query.BookQuery.*;

/**
 * interface which return necessary query
 * depends on demand
 */
@FunctionalInterface
public interface By {
    String getQuery();

    static By byTitle() {
        return () -> SELECT_ALL_BOOKS + SEARCH_BY_TITLE;
    }

    static By byAuthor() {
        return () -> SELECT_ALL_BOOKS + SEARCH_BY_AUTHOR;
    }

    static By byKeywords() {
        return () -> SELECT_ALL_BOOKS + SEARCH_BY_KEYWORDS;
    }

}

package ua.kiyv.training.library.dao;

import static ua.kiyv.training.library.dao.Impl.query.BookQuery.SEARCH_BY_AUTHOR;
import static ua.kiyv.training.library.dao.Impl.query.BookQuery.SEARCH_BY_TITLE;
import static ua.kiyv.training.library.dao.Impl.query.BookQuery.SELECT_ALL_BOOKS;

public interface By {
    String getQuery();

    static By byTitle(){
        return () -> SELECT_ALL_BOOKS + SEARCH_BY_TITLE;
    }

    static By byAuthor(){
        return () -> SELECT_ALL_BOOKS + SEARCH_BY_AUTHOR;
    }

}

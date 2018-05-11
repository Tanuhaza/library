package ua.kiyv.training.library.dao;

import ua.kiyv.training.library.model.Book;

import java.util.Comparator;

import static ua.kiyv.training.library.dao.Impl.query.BookQuery.*;

@FunctionalInterface
public interface By {
    String getQuery();

    static By byTitle() { return () -> SELECT_ALL_BOOKS + SEARCH_BY_TITLE; }

    static By byAuthor() { return () -> SELECT_ALL_BOOKS + SEARCH_BY_AUTHOR; }

    static By byKeywords() {
        return () -> SELECT_ALL_BOOKS + SEARCH_BY_KEYWORDS;
    }
    static By byAll(){
        return new By() {
            @Override
            public String getQuery(){return SELECT_ALL_BOOKS + SEARCH_BY_ALL;
            }
        };
    }
//
//    static By bookComparator(){
//        return
//    }
}

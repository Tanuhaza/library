package ua.kiyv.training.library.dao;

import ua.kiyv.training.library.model.Author;
import ua.kiyv.training.library.model.Book;

import java.util.List;

/**
 * DAO for Book entity
 */

public interface BookDao extends GenericDao<Book> {

    /**
     * match book and author entities in
     * DB table book_author
     *
     * @param book
     * @param author
     * @return
     */
    void matchBookAuthor(Book book, Author author);

    /**
     * delete book by  Id
     *
     * @param id
     * @return
     */
    void deleteById(Integer id);

    /**
     * delete book-author connection  in
     * DB table book_author by book Id
     *
     * @param id
     * @return
     */
    void deleteMatchBookAuthor(Integer id);

    /**
     * find all books by genre Id
     *
     * @param id
     * @return
     */
    List<Book> findByGenreId(Integer id);

    /**
     * find all books by searching value and by query
     * which can be title, author or keywords
     *
     * @param searchValue
     * @param query
     * @return
     */
    List<Book> findBy(String searchValue, By query);
}

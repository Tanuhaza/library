package ua.kiyv.training.library.service;

import ua.kiyv.training.library.dao.By;
import ua.kiyv.training.library.model.*;

import java.util.List;

/**
 * Book service
 */
public interface BookService {
    void create(Book book);

    void createBookAuthor(Book book, Author author);

    void update(Book book);

    void updateBookAuthor(Book book, Author author);

    List<Book> findAllBooks();

    Book findById(Integer id);

    List<Genre> findAllGenres();

    void matchBookAuthor(Book book, Author author);

    void delete(Integer id);

    List<BorrowedBook> findAllBorrowedBooksByUserId(Integer id);

    List<Book> findByGenreId(Integer id);

    void createBorrowedBookByUserId(Integer bookId, Integer userId);

    void delete(BorrowedBook borrowedBook);

    Boolean isBookAvailable(Book book);

    void deleteBorrowedBookByUserId(Integer bookId, Integer userId);

    List<Book> findBy(String searchValue, By query);

    Boolean isBookOnLoanByUser(Integer bookId, Integer userId);
}

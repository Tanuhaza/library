package ua.kiyv.training.library.service;

import ua.kiyv.training.library.model.*;

import java.util.List;

/**
 * Created by Tanya on 17.04.2018.
 */
public interface BookService {
    void create(Book book);
    void update(Book book);
     List<Book> findAllBooks();
     Book findById(int id);
     List<Genre> findAllGenres();
     void matchBookAuthor(Book book, Author author);
     void delete(int id);
     List<BorrowedBook> findAllBorrowedBooksByUserId(int id);
     List<Book> findByGenreId(Integer id);
     void createBorrowedBookByUserId(Integer bookId,Integer userId);
     void delete(BorrowedBook borrowedBook);
     Boolean isBookAvailable(Book book);
     void deleteBorrowedBookByUserId(Integer bookId, Integer userId);
     List<Book> findByAuthor(String searchValue);
     List<Book> findByTitle(String searchValue);
}

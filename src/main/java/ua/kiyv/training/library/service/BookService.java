package ua.kiyv.training.library.service;

import ua.kiyv.training.library.model.*;

import java.util.List;

/**
 * Created by Tanya on 17.04.2018.
 */
public interface BookService {
    void create(Book book);
    void update(Book book);
    public List<Book> findAllBooks();
    public Book findById(int id);
    public List<Genre> findAllGenres();
    public void matchBookAuthor(Book book, Author author);
    public void delete(int id);
    public List<BorrowedBook> findAllBorrowedBooksByUserId(int id);
    public List<Book> findByGenreId(Integer id);
    public void createBorrowedBookByUserId(Integer bookId,Integer userId);
    public void delete(BorrowedBook borrowedBook);
    public Boolean isBookAvailable(Book book);
    public void deleteBorrowedBookByUserId(Integer bookId, Integer userId);
    public List<Book> findByAuthor(String searchValue);
    public List<Book> findByTitle(String searchValue);
}

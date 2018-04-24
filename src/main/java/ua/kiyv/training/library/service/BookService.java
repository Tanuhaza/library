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
}

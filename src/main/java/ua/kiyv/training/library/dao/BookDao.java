package ua.kiyv.training.library.dao;

import ua.kiyv.training.library.model.Author;
import ua.kiyv.training.library.model.Book;

import java.util.List;

public interface BookDao extends  GenericDao<Book> {
    public void matchBookAuthor(Book book, Author author);
    public void deleteById(Integer id);
    public void deleteMatchBookAuthor(Integer id);
    public List<Book> findByGenreId(Integer id);
    List<Book> findBy(String searchValue, By query);
}

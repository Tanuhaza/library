package ua.kiyv.training.library.dao;

import ua.kiyv.training.library.model.Author;
import ua.kiyv.training.library.model.Book;

import java.util.List;

public interface BookDao extends  GenericDao<Book> {
    public void matchBookAuthor(Book book, Author author);
    public List<Book> findByTitle(String title);
    public List<Book> findByAuthor(String author);
    public void deleteById(int id);
    public void deleteMatchBookAuthor(int id);
    public List<Book> findByGenreId(Integer id);

}

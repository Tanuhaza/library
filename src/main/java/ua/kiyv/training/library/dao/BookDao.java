package ua.kiyv.training.library.dao;

import ua.kiyv.training.library.model.Author;
import ua.kiyv.training.library.model.Book;

public interface BookDao extends  GenericDao<Book> {
    public void matchBookAuthor(Book book, Author author);
    public Book findByTitle(String title);
    public void deleteById(int id);
    public void deleteMatchBookAuthor(int id);
}

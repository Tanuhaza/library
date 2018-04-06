package ua.kiyv.training.library.dao.Impl;

import ua.kiyv.training.library.dao.BookDao;
import ua.kiyv.training.library.model.Book;

import java.util.List;

public class JdbcBookDao implements BookDao{
    @Override
    public void create(Book entity) {

    }

    @Override
    public Book findById(int id) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public void update(Book entity) {

    }

    @Override
    public void delete(Book entity) {

    }
}

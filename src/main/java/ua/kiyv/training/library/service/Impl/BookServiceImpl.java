package ua.kiyv.training.library.service.Impl;

import org.apache.log4j.Logger;
import ua.kiyv.training.library.dao.BookDao;
import ua.kiyv.training.library.dao.DaoException;
import ua.kiyv.training.library.dao.Impl.JdbcDaoFactory;
import ua.kiyv.training.library.dao.connection.Jdbc.JdbcTransactionHelper;
import ua.kiyv.training.library.model.Author;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.model.BorrowedBook;
import ua.kiyv.training.library.model.Genre;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.ServiceException;
import ua.kiyv.training.library.utils.constants.LoggerMessages;
import ua.kiyv.training.library.utils.constants.MessageKeys;

import java.util.List;

/**
 * Created by Tanya on 17.04.2018.
 */
public class BookServiceImpl implements BookService {
    private static BookDao bookDao = JdbcDaoFactory.getInstance().createBookDao();
    private static final Logger logger = Logger.getLogger(BookServiceImpl.class);

    @Override
    public void create(Book book) {
        JdbcTransactionHelper.getInstance().beginTransaction();
        try {
            bookDao.create(book);
            JdbcTransactionHelper.getInstance().commitTransaction();
        } catch (DaoException ex) {
            JdbcTransactionHelper.getInstance().rollbackTransaction();
            logger.error(LoggerMessages.WRONG_TRANSACTION);
            throw new ServiceException(ex, MessageKeys.WRONG_TRANSACTION_WHILE_CREATING_BOOK);
        }

    }

    @Override
    public void update(Book book) {
        JdbcTransactionHelper.getInstance().beginTransaction();
        try {
            bookDao.update(book);
            JdbcTransactionHelper.getInstance().commitTransaction();
        } catch (DaoException ex) {
            JdbcTransactionHelper.getInstance().rollbackTransaction();
            logger.error(LoggerMessages.WRONG_TRANSACTION);
            throw new ServiceException(ex, MessageKeys.WRONG_TRANSACTION_WHILE_UPDATING_BOOK);
        }

    }

    @Override
    public void delete(int id) {
        JdbcTransactionHelper.getInstance().beginTransaction();
        try {
            System.out.println("in service delete");
            bookDao.deleteMatchBookAuthor(id);
            System.out.println("delete book-author");
            bookDao.deleteById(id);
            System.out.println("delete book");
            JdbcTransactionHelper.getInstance().commitTransaction();
        } catch (DaoException ex) {
            JdbcTransactionHelper.getInstance().rollbackTransaction();
            logger.error(LoggerMessages.WRONG_TRANSACTION);
            throw new ServiceException(ex, MessageKeys.WRONG_TRANSACTION_WHILE_DELETING_BOOK);
        }

    }

    @Override
    public List<Book> findAllBooks() {
        return (JdbcDaoFactory.getInstance().createBookDao().findAll());
    }

    @Override
    public List<BorrowedBook> findAllBorrowedBooksByUserId(int id) {
        return (JdbcDaoFactory.getInstance().createBorrowedBookDao().findAllByUserId(id));
    }

    @Override
    public List<Genre> findAllGenres() {
        return (JdbcDaoFactory.getInstance().createGenreDao().findAll());
    }

    @Override
    public Book findById(int id) {
        return (JdbcDaoFactory.getInstance().createBookDao().findById(id));
    }

    @Override
    public void matchBookAuthor(Book book, Author author) {
        JdbcDaoFactory.getInstance().createBookDao().matchBookAuthor(book, author);
    }

    @Override
    public List<Book> findByGenreId(Integer id) {
        return JdbcDaoFactory.getInstance().createBookDao().findByGenreId(id);
    }

    @Override
    public void createBorrowedBookByUserId(Book book, int userId) {
        JdbcDaoFactory.getInstance().createBorrowedBookDao().createBorrowedBookByUserId(book,userId);
    }

    @Override
    public void delete(BorrowedBook borrowedBook) {
        JdbcDaoFactory.getInstance().createBorrowedBookDao().delete(borrowedBook);

    }
}

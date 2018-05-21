package ua.kiyv.training.library.service.Impl;

import org.apache.log4j.Logger;
import ua.kiyv.training.library.dao.*;
import ua.kiyv.training.library.exception.DaoException;
import ua.kiyv.training.library.dao.Impl.JdbcDaoFactory;
import ua.kiyv.training.library.dao.connection.Jdbc.JdbcTransactionHelper;
import ua.kiyv.training.library.model.Author;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.model.BorrowedBook;
import ua.kiyv.training.library.model.Genre;
import ua.kiyv.training.library.service.AuthorService;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.exception.ServiceException;
import ua.kiyv.training.library.utils.constants.LoggerMessages;
import ua.kiyv.training.library.utils.constants.MessageKeys;

import java.util.List;
import java.util.Optional;

/**
 * Implementation for Book service
 **/
public class BookServiceImpl implements BookService {
    private static final Logger LOGGER = Logger.getLogger(BookServiceImpl.class);
    private DaoFactory daoFactory;
    private BookDao bookDao;
    private BorrowedBookDao borrowedBookDao;
    private AuthorDao authorDao;

    private BookServiceImpl(DaoFactory instance) {
        this.daoFactory = instance;
        this.bookDao = daoFactory.createBookDao();
        this.borrowedBookDao = daoFactory.createBorrowedBookDao();
        this.authorDao = daoFactory.createAuthorDao();
    }

    private static class Holder {
        private static final BookService INSTANCE = new BookServiceImpl(DaoFactory.getInstance());
    }

    public static BookService getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public void create(Book book) {
        JdbcTransactionHelper.getInstance().beginTransaction();
        try {
            bookDao.create(book);
            JdbcTransactionHelper.getInstance().commitTransaction();
        } catch (DaoException ex) {
            JdbcTransactionHelper.getInstance().rollbackTransaction();
            LOGGER.error(LoggerMessages.WRONG_TRANSACTION);
            throw new ServiceException(ex, MessageKeys.WRONG_TRANSACTION_WHILE_CREATING_BOOK);
        }
    }

    @Override
    public void createBookAuthor(Book book, Author author) {
        JdbcTransactionHelper.getInstance().beginTransaction();
        try {
            bookDao.create(book);
            try {
                Author authorDB = authorDao.findByFirstLastName(author.getFirstName(), author.getLastName());
                bookDao.matchBookAuthor(book, authorDB);
            } catch (DaoException e) {
                authorDao.create(author);
                bookDao.matchBookAuthor(book, author);
            }
            JdbcTransactionHelper.getInstance().commitTransaction();
        } catch (DaoException ex) {
            JdbcTransactionHelper.getInstance().rollbackTransaction();
            LOGGER.error(LoggerMessages.WRONG_TRANSACTION);
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
            LOGGER.error(LoggerMessages.WRONG_TRANSACTION);
            throw new ServiceException(ex, MessageKeys.WRONG_TRANSACTION_WHILE_UPDATING_BOOK);
        }
    }

    @Override
    public void updateBookAuthor(Book book, Author author) {
        JdbcTransactionHelper.getInstance().beginTransaction();
        try {
            bookDao.update(book);
            try {
                Author authorDB = authorDao.findByFirstLastName(author.getFirstName(), author.getLastName());
                bookDao.deleteMatchBookAuthor(book.getId());
                bookDao.matchBookAuthor(book, authorDB);
            } catch (DaoException e) {
                bookDao.deleteMatchBookAuthor(book.getId());
                authorDao.create(author);
                bookDao.matchBookAuthor(book, author);
            }
            JdbcTransactionHelper.getInstance().commitTransaction();
        } catch (DaoException ex) {
            JdbcTransactionHelper.getInstance().rollbackTransaction();
            LOGGER.error(LoggerMessages.WRONG_TRANSACTION);
            throw new ServiceException(ex, MessageKeys.WRONG_TRANSACTION_WHILE_CREATING_BOOK);
        }
    }

    @Override
    public void delete(Integer id) {
        JdbcTransactionHelper.getInstance().beginTransaction();
        try {
            bookDao.deleteMatchBookAuthor(id);
            borrowedBookDao.deleteById(id);
            bookDao.deleteById(id);
            JdbcTransactionHelper.getInstance().commitTransaction();
        } catch (DaoException ex) {
            JdbcTransactionHelper.getInstance().rollbackTransaction();
            LOGGER.error(LoggerMessages.WRONG_TRANSACTION);
            throw new ServiceException(ex, MessageKeys.WRONG_TRANSACTION_WHILE_DELETING_BOOK);
        }
    }

    @Override
    public List<Book> findAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public List<BorrowedBook> findAllBorrowedBooksByUserId(Integer id) {
        return (borrowedBookDao.findAllByUserId(id));
    }

    @Override
    public List<Genre> findAllGenres() {
        return daoFactory.createGenreDao().findAll();
    }

    @Override
    public Book findById(Integer id) {
        return Optional.ofNullable(bookDao.findById(id))
                .orElseThrow(()->new ServiceException(MessageKeys.WRONG_BOOK_DB_NO_ID_OBTAINED));
    }

    @Override
    public void matchBookAuthor(Book book, Author author) {
        bookDao.matchBookAuthor(book, author);
    }

    @Override
    public List<Book> findByGenreId(Integer id) {
        return bookDao.findByGenreId(id);
    }

    @Override
    public void createBorrowedBookByUserId(Integer bookId, Integer userId) {
        Book book = bookDao.findById(bookId);
        if (isBookAvailable(book) && (!isBookOnLoanByUser(bookId, userId))) {
            book.setQuantity(book.getQuantity() - 1);
            book.setAvaliable(isBookAvailable(book));
            bookDao.update(book);
            borrowedBookDao.createBorrowedBookByUserId(bookId, userId);
        } else {
            throw new ServiceException(MessageKeys.WRONG_BOOK_IS_NOT_AVAILABLE);
        }
    }

    @Override
    public void delete(BorrowedBook borrowedBook) {
        borrowedBookDao.delete(borrowedBook);
    }

    @Override
    public Boolean isBookAvailable(Book book) {
        return book.getQuantity() > 0;
    }

    public Boolean isBookOnLoanByUser(Integer bookId, Integer userId) {
        return borrowedBookDao.isBookOnLoanByUser(bookId, userId);

    }

    @Override
    public void deleteBorrowedBookByUserId(Integer bookId, Integer userId) {
        JdbcTransactionHelper.getInstance().beginTransaction();
        try {
            Book book = bookDao.findById(bookId);
            borrowedBookDao.deleteBorrowedBookByUserId(bookId, userId);
            book.setQuantity(book.getQuantity() + 1);
            book.setAvaliable(isBookAvailable(book));
            bookDao.update(book);
            JdbcTransactionHelper.getInstance().commitTransaction();
        } catch (DaoException ex) {
            JdbcTransactionHelper.getInstance().rollbackTransaction();
            LOGGER.error(LoggerMessages.WRONG_TRANSACTION);
            throw new ServiceException(ex, MessageKeys.WRONG_TRANSACTION_WHILE_DELETING_BOOK);
        }
    }

    @Override
    public List<Book> findBy(String searchValue, By query) {
        return bookDao.findBy(searchValue, query);
    }

}


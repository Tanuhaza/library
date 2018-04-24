package ua.kiyv.training.library.dao.Impl;

import org.apache.log4j.Logger;
import ua.kiyv.training.library.dao.BorrowedBookDao;
import ua.kiyv.training.library.dao.DaoException;
import ua.kiyv.training.library.dao.Impl.mapper.AuthorMapper;
import ua.kiyv.training.library.dao.Impl.mapper.BookMapper;
import ua.kiyv.training.library.dao.Impl.mapper.BorrowedBookMapper;
import ua.kiyv.training.library.dao.Impl.query.BorrowedBookQuery;
import ua.kiyv.training.library.dao.connection.DaoConnection;
import ua.kiyv.training.library.dao.connection.Jdbc.JdbcTransactionHelper;
import ua.kiyv.training.library.model.Author;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.model.BorrowedBook;
import ua.kiyv.training.library.utils.constants.LoggerMessages;
import ua.kiyv.training.library.utils.constants.MessageKeys;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ua.kiyv.training.library.dao.Impl.query.BorrowedBookQuery.FILTER_BY_USER_ID;
import static ua.kiyv.training.library.dao.Impl.query.BorrowedBookQuery.SELECT_ALL_BORROWED_BOOKS;

public class JdbcBorrowedBookDao implements BorrowedBookDao, BorrowedBookQuery {
    JdbcBorrowedBookDao() {
    }

    private static final Logger logger = Logger.getLogger(JdbcBorrowedBookDao.class);

    @Override
    public void create(BorrowedBook entity) {

    }

    @Override
    public void createBorrowedBookByUserId(BorrowedBook borrowedBook,int userId) {
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_BORROWED_BOOK)) {
            statement.setInt(1, borrowedBook.getId());
            statement.setInt(2, borrowedBook.getGenreId());
            statement.setDate(3, (Date) borrowedBook.getStartDate());
            statement.setDate(4, (Date) borrowedBook.getDueToReturnDate());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DaoException(MessageKeys.WRONG_BORROWED_BOOK_DB_CREATING_NO_ROWS_AFFECTED);
            }
        } catch (SQLException ex) {
            logger.error(LoggerMessages.ERROR_CREATE_NEW_BORROWED_BOOK + borrowedBook.toString());
            throw new DaoException(ex, MessageKeys.WRONG_BORROWED_BOOK_DB_CAN_NOT_CREATE);
        }

    }

    @Override
    public BorrowedBook findById(int id) {
        return null;
    }

    @Override
    public List<BorrowedBook> findAll() {
        return null;
    }

    @Override
    public List<BorrowedBook> findAllByUserId(int id) {

        BorrowedBook borrowedBook = new BorrowedBook();
        Author author = new Author();
        Map<Integer, BorrowedBook> books = new HashMap<>();
        Map<Integer, Author> authors = new HashMap<>();
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BORROWED_BOOKS + FILTER_BY_USER_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            BorrowedBookMapper bookMapper = new BorrowedBookMapper();
            AuthorMapper authorMapper = new AuthorMapper();
            while (resultSet.next()) {
                borrowedBook = bookMapper.extractFromResultSet(resultSet);
                author = authorMapper.extractFromResultSet(resultSet);
                borrowedBook = bookMapper.makeUnique(books, borrowedBook);
                author = authorMapper.makeUnique(authors, author);
                borrowedBook.getAuthors().add(author);
            }
            resultSet.close();
        } catch (SQLException ex) {
            logger.error(LoggerMessages.ERROR_FIND_ALL_BORROWED_BOOKS);
            throw new DaoException(ex, MessageKeys.WRONG_BORROWED_BOOK_DB_CAN_NOT_GET_ALL_BOROOWED_BOOKS);
        }
        return new ArrayList<>(books.values());
    }

    @Override
    public void update(BorrowedBook entity) {

    }

    @Override
    public void delete(BorrowedBook borrowedBook) {
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BORROWED_BOOK)) {

            statement.setInt(1, borrowedBook.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DaoException(MessageKeys.WRONG_BOOK_DB_DELETING_NO_ROWS_AFFECTED);
            }
        } catch (SQLException ex) {
            logger.error(LoggerMessages.ERROR_DELETE_BOOK + borrowedBook.getId());
            throw new DaoException(ex, MessageKeys.WRONG_BOOK_DB_CAN_NOT_DELETE);
        }
    }
}

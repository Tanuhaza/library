package ua.kiyv.training.library.dao.Impl;

import org.apache.log4j.Logger;
import ua.kiyv.training.library.dao.BookDao;
import ua.kiyv.training.library.dao.DaoException;
import ua.kiyv.training.library.dao.Impl.mapper.AuthorMapper;
import ua.kiyv.training.library.dao.Impl.mapper.BookMapper;
import ua.kiyv.training.library.dao.Impl.query.BookQuery;
import ua.kiyv.training.library.dao.connection.DaoConnection;
import ua.kiyv.training.library.dao.connection.Jdbc.JdbcTransactionHelper;
import ua.kiyv.training.library.model.Author;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.utils.constants.LoggerMessages;
import ua.kiyv.training.library.utils.constants.MessageKeys;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcBookDao implements BookDao, BookQuery {

    JdbcBookDao() {
    }

    private static final Logger logger = Logger.getLogger(JdbcBookDao.class);

    @Override
    public void create(Book book) {
        String sqlStatement = CREATE_BOOK;
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getDescription());
            statement.setString(3, book.getPictureId());
            statement.setBoolean(4, book.isAvaliable());
            statement.setInt(5, book.getQuantity());
            statement.setInt(6, book.getYear());
            statement.setInt(7, book.getGenreId());
            statement.setString(8, book.getKeywords());
//            statement.setDate(9, (Date) book.getAddedDate());
            statement.setInt(9, book.getRate());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DaoException(MessageKeys.WRONG_BOOK_DB_CREATING_NO_ROWS_AFFECTED);
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (!generatedKeys.next()) {
                throw new DaoException(MessageKeys.WRONG_BOOK_DB_NO_ID_OBTAINED);
            }
            Integer id = generatedKeys.getInt(1);
            book.setId(id);
            generatedKeys.close();
            statement.close();
        } catch (SQLException ex) {
            logger.error(LoggerMessages.ERROR_CREATE_NEW_BOOK + book.toString());
            throw new DaoException(ex, MessageKeys.WRONG_BOOK_DB_CAN_NOT_CREATE);
        }
    }

    @Override
    public Book findById(int id) {
        Map<Integer, Book> books = new HashMap<>();
        Map<Integer, Author> authors = new HashMap<>();
        Book book = null;
        Author author =null;
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BOOKS+ FILTER_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
           while (resultSet.next()) {
                BookMapper bookMapper = new BookMapper();
                AuthorMapper authorMapper = new AuthorMapper();
                book = bookMapper.extractFromResultSet(resultSet);
                author = authorMapper.extractFromResultSet(resultSet);
                book = bookMapper.makeUnique(books, book);
                author = authorMapper.makeUnique(authors, author);
                book.getAuthors().add(author);
            }
            resultSet.close();
            statement.close();

        } catch (SQLException ex) {
            logger.error(LoggerMessages.ERROR_FIND_AUTHOR_BY_ID + id);
            throw new DaoException(ex, MessageKeys.WRONG_BOOK_DB_CAN_NOT_GET);
        }
        return book;
    }


    @Override
    public List<Book> findAll() {
        Book book = new Book();
        Author author = new Author();
        Map<Integer, Book> books = new HashMap<>();
        Map<Integer, Author> authors = new HashMap<>();
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_BOOKS);
            BookMapper bookMapper = new BookMapper();
            AuthorMapper authorMapper = new AuthorMapper();
            while (resultSet.next()) {
                book = bookMapper.extractFromResultSet(resultSet);
                author = authorMapper.extractFromResultSet(resultSet);
                book = bookMapper.makeUnique(books, book);
                author = authorMapper.makeUnique(authors, author);
                book.getAuthors().add(author);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            logger.error(LoggerMessages.ERROR_FIND_ALL_AUTHOR);
            throw new DaoException(ex, MessageKeys.WRONG_AUTHOR_DB_CAN_NOT_GET_ALL_AUTHORS);
        }
        return new ArrayList<>(books.values());
    }

    @Override
    public void update(Book book) {
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getDescription());
            statement.setString(3, book.getPictureId());
            statement.setBoolean(4, book.isAvaliable());
            statement.setInt(5, book.getQuantity());
            statement.setInt(6, book.getYear());
            statement.setInt(7, book.getGenreId());
            statement.setString(8, book.getKeywords());
//            statement.setDate(9, (Date) book.getAddedDate());
            statement.setInt(9, book.getRate());
            statement.setInt(10, book.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DaoException(MessageKeys.WRONG_BOOK_DB_UPDATING_NO_ROWS_AFFECTED);
            }
            statement.close();
        } catch (SQLException ex) {
            logger.error(LoggerMessages.ERROR_UPDATE_BOOK + book.toString());
            throw new DaoException(ex, MessageKeys.WRONG_BOOK_DB_CAN_NOT_UPDATE);
        }
    }

    @Override
    public void delete(Book book) {
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_BOOK);
            statement.setInt(1, book.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DaoException(MessageKeys.WRONG_BOOK_DB_DELETING_NO_ROWS_AFFECTED);
            }
            statement.close();
        } catch (SQLException ex) {
            logger.error(LoggerMessages.ERROR_DELETE_BOOK + book.getId());
            throw new DaoException(ex, MessageKeys.WRONG_BOOK_DB_CAN_NOT_DELETE);
        }

    }
}

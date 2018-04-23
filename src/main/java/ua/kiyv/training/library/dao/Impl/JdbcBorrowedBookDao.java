package ua.kiyv.training.library.dao.Impl;

import ua.kiyv.training.library.dao.BorrowedBookDao;
import ua.kiyv.training.library.dao.DaoException;
import ua.kiyv.training.library.dao.Impl.mapper.AuthorMapper;
import ua.kiyv.training.library.dao.Impl.mapper.BookMapper;
import ua.kiyv.training.library.dao.connection.DaoConnection;
import ua.kiyv.training.library.dao.connection.Jdbc.JdbcTransactionHelper;
import ua.kiyv.training.library.model.Author;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.utils.constants.LoggerMessages;
import ua.kiyv.training.library.utils.constants.MessageKeys;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ua.kiyv.training.library.dao.Impl.query.BorrowedBookQuery.FILTER_BY_USER_ID;
import static ua.kiyv.training.library.dao.Impl.query.BorrowedBookQuery.SELECT_ALL_BORROWED_BOOKS;

public class JdbcBorrowedBookDao implements BorrowedBookDao {
    @Override
    public void create(BorrowedBookDao entity) {

    }

    @Override
    public BorrowedBookDao findById(int id) {
        return null;
    }

    @Override
    public List<BorrowedBookDao> findAll() {
        return null;
    }

    @Override
    public List<BorrowedBookDao> findAllByUserId(int id) {

        Book book = new Book();
        Author author = new Author();
        Map<Integer, Book> books = new HashMap<>();
        Map<Integer, Author> authors = new HashMap<>();
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_BORROWED_BOOKS+FILTER_BY_USER_ID);
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
    public void update(BorrowedBookDao entity) {

    }

    @Override
    public void delete(BorrowedBookDao entity) {

    }
}

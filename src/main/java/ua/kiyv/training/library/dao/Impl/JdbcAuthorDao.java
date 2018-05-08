package ua.kiyv.training.library.dao.Impl;

import org.apache.log4j.Logger;
import ua.kiyv.training.library.dao.AuthorDao;
import ua.kiyv.training.library.exception.DaoException;
import ua.kiyv.training.library.dao.Impl.mapper.AuthorMapper;
import ua.kiyv.training.library.dao.connection.DaoConnection;
import ua.kiyv.training.library.dao.connection.Jdbc.JdbcTransactionHelper;
import ua.kiyv.training.library.model.Author;
import ua.kiyv.training.library.utils.constants.LoggerMessages;
import ua.kiyv.training.library.utils.constants.MessageKeys;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static ua.kiyv.training.library.dao.Impl.query.AuthorQuery.*;

public class JdbcAuthorDao implements AuthorDao {

    JdbcAuthorDao() {
    }

    private static final Logger logger = Logger.getLogger(JdbcAuthorDao.class);

    @Override
    public void create(Author author) {
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(CREATE_AUTHOR,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, author.getFirstName());
            statement.setString(2, author.getLastName());
            statement.setString(3, author.getLastName()+author.getFirstName());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DaoException(MessageKeys.WRONG_AUTHOR_DB_CREATING_NO_ROWS_AFFECTED);
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (!generatedKeys.next()) {
                throw new DaoException(MessageKeys.WRONG_AUTHOR_DB_NO_ID_OBTAINED);
            }
            Integer id = generatedKeys.getInt(1);
            author.setId(id);
            generatedKeys.close();
            statement.close();
        } catch (SQLException ex) {
            logger.error(LoggerMessages.ERROR_CREATE_NEW_AUTHOR + author.toString());
            throw new DaoException(ex, MessageKeys.WRONG_AUTHOR_DB_CAN_NOT_CREATE);
        }

    }

    @Override
    public Author findById(int id) {
            Author author;
            try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection()) {
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL_AUTHORS+FILTER_BY_ID);
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (!resultSet.next()) {
                    throw new DaoException(MessageKeys.WRONG_AUTHOR_DB_NO_ID_EXIST);
                }
                AuthorMapper authorMapper = new AuthorMapper();
                author = authorMapper.extractFromResultSet(resultSet);
                resultSet.close();
                statement.close();
            } catch (SQLException ex) {
                logger.error(LoggerMessages.ERROR_FIND_AUTHOR_BY_ID + id);
                throw new DaoException(ex, MessageKeys.WRONG_AUTHOR_DB_CAN_NOT_GET);
            }
            return author;
        }

    @Override
    public Author findByFirstLastName(String firstName,String lastName) {
        Author author;
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_AUTHORS+FILTER_BY_FIRST_LAST_NAME)) {

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new DaoException(MessageKeys.WRONG_AUTHOR_DB_NO_ID_EXIST);
            }
            AuthorMapper authorMapper = new AuthorMapper();
            author = authorMapper.extractFromResultSet(resultSet);
            resultSet.close();
        } catch (SQLException ex) {
            logger.error(LoggerMessages.ERROR_FIND_AUTHOR_BY_ID + firstName +" "+lastName);
            throw new DaoException(ex, MessageKeys.WRONG_AUTHOR_DB_CAN_NOT_GET);
        }
        return author;
    }

    @Override
    public List<Author> findAll() {
        Author author;
        List<Author> authors = new ArrayList<>();
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_AUTHORS);
            AuthorMapper authorMapper=new AuthorMapper();
            while (resultSet.next()) {
                author = authorMapper.extractFromResultSet(resultSet);
                authors.add(author);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            logger.error(LoggerMessages.ERROR_FIND_ALL_AUTHOR);
            throw new DaoException(ex, MessageKeys.WRONG_AUTHOR_DB_CAN_NOT_GET_ALL_AUTHORS);
        }
        return authors;
    }

    @Override
    public void update(Author author) {
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_AUTHOR);
            statement.setString(1, author.getFirstName());
            statement.setString(2, author.getLastName());
            statement.setInt(3, author.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DaoException(MessageKeys.WRONG_AUTHOR_DB_UPDATING_NO_ROWS_AFFECTED);
            }
            statement.close();
        } catch (SQLException ex) {
            logger.error(LoggerMessages.ERROR_UPDATE_AUTHOR + author.toString());
            throw new DaoException(ex, MessageKeys.WRONG_AUTHOR_DB_CAN_NOT_UPDATE);
        }

    }

    @Override
    public void delete(Author author) {
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_AUTHOR);
            statement.setInt(1, author.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DaoException(MessageKeys.WRONG_AUTHOR_DB_DELETING_NO_ROWS_AFFECTED);
            }
            statement.close();
        } catch (SQLException ex) {
            logger.error(LoggerMessages.ERROR_DELETE_AUTHOR + author.getId());
            throw new DaoException(ex, MessageKeys.WRONG_AUTHOR_DB_CAN_NOT_DELETE);
        }

    }
}

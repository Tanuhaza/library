package ua.kiyv.training.library.dao.Impl;

import org.apache.log4j.Logger;
import ua.kiyv.training.library.dao.AuthorDao;
import ua.kiyv.training.library.dao.DaoException;
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

public class JdbcAuthorDao implements AuthorDao {

    JdbcAuthorDao() {
    }

    private static final Logger logger = Logger.getLogger(JdbcAuthorDao.class);

    @Override
    public void create(Author author) {
        String sqlStatement = "INSERT INTO author (firstName,lastName) VALUES (?, ?)";
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, author.getFirstName());
            statement.setString(2, author.getLastName());
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
            String sqlStatement = "SELECT * FROM author WHERE id = ?";
            Author author;
            try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection()) {
                PreparedStatement statement = connection.prepareStatement(sqlStatement);
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
    public List<Author> findAll() {
        String sqlStatement = "SELECT * FROM author";
        Author author;
        List<Author> authors = new ArrayList<>();
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlStatement);
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
        String sqlStatement = "UPDATE author SET firstName = ?, lastName = ? WHERE id = ?";
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
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
        String sqlStatement = "DELETE FROM author WHERE id = ?";
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
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

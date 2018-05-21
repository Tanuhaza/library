package ua.kiyv.training.library.dao.Impl;

import org.apache.log4j.Logger;
import ua.kiyv.training.library.exception.DaoException;
import ua.kiyv.training.library.dao.Impl.mapper.BorrowedBookMapper;
import ua.kiyv.training.library.dao.Impl.mapper.UserMapper;
import ua.kiyv.training.library.dao.UserDao;
import ua.kiyv.training.library.dao.connection.DaoConnection;
import ua.kiyv.training.library.dao.connection.Jdbc.JdbcTransactionHelper;
import ua.kiyv.training.library.model.BorrowedBook;
import ua.kiyv.training.library.model.User;
import ua.kiyv.training.library.utils.constants.LoggerMessages;
import ua.kiyv.training.library.utils.constants.MessageKeys;

import java.sql.*;
import java.util.*;

import static ua.kiyv.training.library.dao.Impl.query.UserQuery.*;

/**
 * * Implementation of user dao, which works with MySql using jdbc
 */
public class JdbcUserDao implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(JdbcUserDao.class);

    @Override
    public void create(User user) {
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_USER,
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getRole().toString());

            Integer affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DaoException(MessageKeys.WRONG_USER_DB_CREATING_NO_ROWS_AFFECTED);
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (!generatedKeys.next()) {
                throw new DaoException(MessageKeys.WRONG_USER_DB_NO_ID_OBTAINED);
            }
            Integer id = generatedKeys.getInt(1);
            user.setId(id);
            generatedKeys.close();
        } catch (SQLException ex) {
            LOGGER.error(LoggerMessages.ERROR_CREATE_NEW_USER + user.toString());
            throw new DaoException(ex, MessageKeys.WRONG_USER_DB_CAN_NOT_CREATE);
        }
    }

    @Override
    public User findById(Integer id) {
        User user;
        BorrowedBook borrowedBook;
        Map<Integer, User> users = new HashMap<>();
        Map<Integer, BorrowedBook> borrowedBooks = new HashMap<>();
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USERS + FILTER_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new DaoException(MessageKeys.WRONG_USER_DB_NO_ID_EXIST);
            }
            UserMapper userMapper = new UserMapper();
            BorrowedBookMapper bookMapper = new BorrowedBookMapper();
            user = userMapper.extractFromResultSet(resultSet);
            borrowedBook = bookMapper.extractFromResultSet(resultSet);
            user = userMapper.makeUnique(users, user);
            borrowedBook = bookMapper.makeUnique(borrowedBooks, borrowedBook);
            user.getBorrowedBooks().add(borrowedBook);
            resultSet.close();
        } catch (SQLException ex) {
            LOGGER.error(LoggerMessages.ERROR_FIND_AUTHOR_BY_ID + id);
            throw new DaoException(ex, MessageKeys.WRONG_USER_DB_CAN_NOT_GET);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        User user;
        BorrowedBook borrowedBook;
        Map<Integer, User> users = new HashMap<>();
        Map<Integer, BorrowedBook> borrowedBooks = new HashMap<>();
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS)) {
            UserMapper userMapper = new UserMapper();
            BorrowedBookMapper bookMapper = new BorrowedBookMapper();
            while (resultSet.next()) {
                user = userMapper.extractFromResultSet(resultSet);
                borrowedBook = bookMapper.extractFromResultSet(resultSet);
                user = userMapper.makeUnique(users, user);
                borrowedBook = bookMapper.makeUnique(borrowedBooks, borrowedBook);
                user.getBorrowedBooks().add(borrowedBook);
            }
        } catch (SQLException ex) {
            LOGGER.error(LoggerMessages.ERROR_FIND_ALL_USERS);
            throw new DaoException(ex, MessageKeys.WRONG_USER_DB_CAN_NOT_GET_ALL_USERS);
        }
        return new ArrayList<>(users.values());
    }

    @Override
    public void update(User user) {
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getRole().toString());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DaoException(MessageKeys.WRONG_USER_DB_UPDATING_NO_ROWS_AFFECTED);
            }
        } catch (SQLException ex) {
            LOGGER.error(LoggerMessages.ERROR_UPDATE_USER + user.toString());
            throw new DaoException(ex, MessageKeys.WRONG_USER_DB_CAN_NOT_UPDATE);
        }
    }

    @Override
    public void delete(User user) {
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USER)) {
            statement.setInt(1, user.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DaoException(MessageKeys.WRONG_USER_DB_DELETING_NO_ROWS_AFFECTED);
            }
        } catch (SQLException ex) {
            LOGGER.error(LoggerMessages.ERROR_DELETE_USER + user.getId());
            throw new DaoException(ex, MessageKeys.WRONG_USER_DB_CAN_NOT_DELETE);
        }
    }

    @Override
    public User findUserByEmail(String email) {
        User result;
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_EMAIL)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (!resultSet.next()) {
                    throw new DaoException(MessageKeys.WRONG_USER_DB_NO_ID_EXIST);
                }
                UserMapper userMapper = new UserMapper();
                result = userMapper.extractFromResultSet(resultSet);
            }
        } catch (SQLException ex) {
            LOGGER.error(LoggerMessages.ERROR_FIND_AUTHOR_BY_EMAIL + email);
            throw new DaoException(ex, MessageKeys.WRONG_USER_DB_CAN_NOT_GET);
        }
        return result;
    }

    @Override
    public int countAllUsers() {
        int totalNumberOfUsers;
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(COUNT_USERS);
             ResultSet resultSet = statement.executeQuery()) {
            if (!resultSet.next()) {
                throw new DaoException(MessageKeys.WRONG_USER_DB_CAN_NOT_GET_ALL_USERS);
            }
            totalNumberOfUsers = resultSet.getInt("total_count");
        } catch (SQLException ex) {
            LOGGER.error(LoggerMessages.ERROR_FIND_ALL_USERS);
            throw new DaoException(ex, MessageKeys.WRONG_USER_DB_CAN_NOT_GET_ALL_USERS);
        }
        return totalNumberOfUsers;
    }

    @Override
    public List<User> getAllWithLimitPerPage(Integer startFrom, Integer quantity) {
        User user;
        List<User> users = new ArrayList<>();
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_WITH_LIMIT_PER_PAGE);
            statement.setInt(1, startFrom);
            statement.setInt(2, quantity);
            ResultSet resultSet = statement.executeQuery();
            UserMapper userMapper = new UserMapper();
            while (resultSet.next()) {
                user = userMapper.extractFromResultSet(resultSet);
                users.add(user);
            }
            resultSet.close();
        } catch (SQLException ex) {
            LOGGER.error(LoggerMessages.ERROR_FIND_ALL_USERS);
            throw new DaoException(ex, MessageKeys.WRONG_USER_DB_CAN_NOT_GET_ALL_USERS);
        }
        return users;
    }
}


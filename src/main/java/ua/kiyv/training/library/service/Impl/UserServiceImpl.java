package ua.kiyv.training.library.service.Impl;


import org.apache.log4j.Logger;
import ua.kiyv.training.library.dao.AuthorDao;
import ua.kiyv.training.library.exception.DaoException;
import ua.kiyv.training.library.dao.DaoFactory;
import ua.kiyv.training.library.dao.Impl.JdbcDaoFactory;
import ua.kiyv.training.library.dao.UserDao;
import ua.kiyv.training.library.dao.connection.Jdbc.JdbcTransactionHelper;
import ua.kiyv.training.library.model.User;
import ua.kiyv.training.library.exception.ServiceException;
import ua.kiyv.training.library.service.UserService;
import ua.kiyv.training.library.utils.constants.LoggerMessages;
import ua.kiyv.training.library.utils.constants.MessageKeys;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

/**
 * Implementation for User service
 **/
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = Logger.getLogger(BookServiceImpl.class);

    private DaoFactory daoFactory;
    private UserDao userDao;

    private UserServiceImpl(DaoFactory instance) {
        this.daoFactory = instance;
        this.userDao = daoFactory.createUserDao();
    }

    private static class Holder {
        private static final UserService INSTANCE = new UserServiceImpl(DaoFactory.getInstance());
    }

    public static UserService getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public void create(User user) {
        JdbcTransactionHelper.getInstance().beginTransaction();
        try {
            userDao.create(user);
            JdbcTransactionHelper.getInstance().commitTransaction();
        } catch (DaoException ex) {
            JdbcTransactionHelper.getInstance().rollbackTransaction();
            LOGGER.error(LoggerMessages.WRONG_TRANSACTION);
            throw new ServiceException(ex, MessageKeys.WRONG_TRANSACTION_WHILE_CREATING_USER);
        }
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.of(userDao.findById(id));
    }

    @Override
    public List<User> findAll() {
        return (userDao.findAll());
    }

    @Override
    public void update(User user) {
        JdbcTransactionHelper.getInstance().beginTransaction();
        try {
            userDao.update(user);
            JdbcTransactionHelper.getInstance().commitTransaction();
        } catch (DaoException ex) {
            JdbcTransactionHelper.getInstance().rollbackTransaction();
            LOGGER.error(LoggerMessages.WRONG_TRANSACTION);
            throw new ServiceException(ex, MessageKeys.WRONG_TRANSACTION_WHILE_UPDATING_USER);
        }
    }

    @Override
    public void delete(User user) {
        JdbcTransactionHelper.getInstance().beginTransaction();
        try {
            userDao.delete(user);
            JdbcTransactionHelper.getInstance().commitTransaction();
        } catch (DaoException ex) {
            JdbcTransactionHelper.getInstance().rollbackTransaction();
            LOGGER.error(LoggerMessages.WRONG_TRANSACTION);
            throw new ServiceException(ex, MessageKeys.WRONG_TRANSACTION_WHILE_UPDATING_USER);
        }
    }

    @Override
    public Optional<User> getUserByEmailPassword(String email, String password) {
        User user = Optional.of(userDao.findUserByEmail(email)).filter(person -> password.equals(person.getPassword()))
                .orElseThrow(() -> new ServiceException(MessageKeys.WRONG_LOGIN_DATA));
        return Optional.of(user);
    }

    @Override
    public int countAllUsers() {
        return userDao.countAllUsers();
    }

    @Override
    public List<User> getAllWithLimitPerPage(Integer startFrom, Integer quantity) {
        return userDao.getAllWithLimitPerPage(startFrom, quantity);
    }

    public String encrypt(String password) {
        String result = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedByteArray = digest.digest(password.getBytes("UTF-8"));
            result = Base64.getEncoder().encodeToString(hashedByteArray);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            LOGGER.info(LoggerMessages.WRONG_TRANSACTION);
            e.printStackTrace();
        }
        return result;
    }
}

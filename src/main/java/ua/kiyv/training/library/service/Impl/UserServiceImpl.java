package ua.kiyv.training.library.service.Impl;

import org.apache.log4j.Logger;
import ua.kiyv.training.library.dao.DaoException;
import ua.kiyv.training.library.dao.DaoFactory;
import ua.kiyv.training.library.dao.Impl.JdbcDaoFactory;
import ua.kiyv.training.library.dao.UserDao;
import ua.kiyv.training.library.dao.connection.Jdbc.JdbcTransactionHelper;
import ua.kiyv.training.library.model.User;
import ua.kiyv.training.library.service.ServiceException;
import ua.kiyv.training.library.service.UserService;
import ua.kiyv.training.library.utils.constants.LoggerMessages;
import ua.kiyv.training.library.utils.constants.MessageKeys;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{
//    private UserServiceImpl(){};

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Override
    public void create(User user) {
        JdbcTransactionHelper.getInstance().beginTransaction();
        try {
            JdbcDaoFactory.getInstance().createUserDao().create(user);
            JdbcTransactionHelper.getInstance().commitTransaction();
        } catch (DaoException ex) {
            JdbcTransactionHelper.getInstance().rollbackTransaction();
            logger.error(LoggerMessages.WRONG_TRANSACTION);
            throw new ServiceException(ex, MessageKeys.WRONG_TRANSACTION);
        }

    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.of(JdbcDaoFactory.getInstance().createUserDao().findById(id));
    }

    @Override
    public List<User> findAll() {
        return (JdbcDaoFactory.getInstance().createUserDao().findAll());
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public Optional<User> getUserByEmailPassword(String email, String password){
        UserDao userDao =DaoFactory.getInstance().createUserDao();
            User user = userDao.findUserByEmail(email)
                    .filter( person-> password.equals(person.getPassword()))
                    .orElseThrow(()->new ServiceException(MessageKeys.WRONG_LOGIN_DATA));
            return Optional.of(user);
        }
}

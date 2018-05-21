package ua.kiyv.training.library.service.Impl;

import org.apache.log4j.Logger;
import ua.kiyv.training.library.dao.AuthorDao;
import ua.kiyv.training.library.exception.DaoException;
import ua.kiyv.training.library.dao.DaoFactory;
import ua.kiyv.training.library.dao.connection.Jdbc.JdbcTransactionHelper;
import ua.kiyv.training.library.model.Author;
import ua.kiyv.training.library.service.AuthorService;
import ua.kiyv.training.library.exception.ServiceException;
import ua.kiyv.training.library.utils.constants.LoggerMessages;
import ua.kiyv.training.library.utils.constants.MessageKeys;

/**
 * Implementation for Author service
**/
public class AuthorServiceImpl implements AuthorService {

    private static final Logger LOGGER = Logger.getLogger(BookServiceImpl.class);

    private DaoFactory daoFactory;
    private AuthorDao authorDao;

    private AuthorServiceImpl(DaoFactory instance) {
        this.daoFactory = instance;
        this.authorDao = daoFactory.createAuthorDao();
    }

    private static class Holder {
        private static final AuthorService INSTANCE = new AuthorServiceImpl(DaoFactory.getInstance());
    }

    public static AuthorService getInstance() {
        return Holder.INSTANCE;
    }


    @Override
    public void create(Author author) {
        JdbcTransactionHelper.getInstance().beginTransaction();
        try {
           authorDao.create(author);
            JdbcTransactionHelper.getInstance().commitTransaction();
        } catch (DaoException ex) {
            JdbcTransactionHelper.getInstance().rollbackTransaction();
            LOGGER.error(LoggerMessages.WRONG_TRANSACTION);
            throw new ServiceException(ex, MessageKeys.WRONG_TRANSACTION_WHILE_CREATING_AUTHOR);
        }

    }

    @Override
    public void update(Author author) {
        JdbcTransactionHelper.getInstance().beginTransaction();
        try {
            authorDao.update(author);
            JdbcTransactionHelper.getInstance().commitTransaction();
        } catch (DaoException ex) {
            JdbcTransactionHelper.getInstance().rollbackTransaction();
            LOGGER.error(LoggerMessages.WRONG_TRANSACTION);
            throw new ServiceException(ex, MessageKeys.WRONG_TRANSACTION_WHILE_UPDATING_AUTHOR);
        }

    }


}

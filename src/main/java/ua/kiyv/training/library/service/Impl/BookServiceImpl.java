package ua.kiyv.training.library.service.Impl;

import org.apache.log4j.Logger;
import ua.kiyv.training.library.dao.DaoException;
import ua.kiyv.training.library.dao.Impl.JdbcDaoFactory;
import ua.kiyv.training.library.dao.connection.Jdbc.JdbcTransactionHelper;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.model.User;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.ServiceException;
import ua.kiyv.training.library.utils.constants.LoggerMessages;
import ua.kiyv.training.library.utils.constants.MessageKeys;

/**
 * Created by Tanya on 17.04.2018.
 */
public class BookServiceImpl implements BookService {

    private static final Logger logger = Logger.getLogger(BookServiceImpl.class);

    @Override
    public void create(Book book) {
        JdbcTransactionHelper.getInstance().beginTransaction();
        try {
            JdbcDaoFactory.getInstance().createBookDao().create(book);
            JdbcTransactionHelper.getInstance().commitTransaction();
        } catch (DaoException ex) {
            JdbcTransactionHelper.getInstance().rollbackTransaction();
            logger.error(LoggerMessages.WRONG_TRANSACTION);
            throw new ServiceException(ex, MessageKeys.WRONG_TRANSACTION);
        }

    }

    @Override
    public void update(Book book) {
        JdbcTransactionHelper.getInstance().beginTransaction();
        try {
            JdbcDaoFactory.getInstance().createBookDao().update(book);
            JdbcTransactionHelper.getInstance().commitTransaction();
        } catch (DaoException ex) {
            JdbcTransactionHelper.getInstance().rollbackTransaction();
            logger.error(LoggerMessages.WRONG_TRANSACTION);
            throw new ServiceException(ex, MessageKeys.WRONG_TRANSACTION);
        }

    }
}
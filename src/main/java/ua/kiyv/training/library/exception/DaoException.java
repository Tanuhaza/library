package ua.kiyv.training.library.exception;

/**
 * this class represents custom exception for dao layer
 */
public class DaoException extends ApplicationException {

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, String messageKey) {
        super(message, messageKey);
    }

    public DaoException(Throwable cause, String message) {
        super(cause, message);
    }
}

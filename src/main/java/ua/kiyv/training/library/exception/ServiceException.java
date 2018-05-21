package ua.kiyv.training.library.exception;

/**
 * this class represents custom exception for service layer
 */
public class ServiceException extends ApplicationException {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, String messageKey) {
        super(message, messageKey);
    }

    public ServiceException(Throwable cause, String message) {
        super(cause, message);
    }

}

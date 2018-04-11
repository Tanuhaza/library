package ua.kiyv.training.library.service;


import ua.kiyv.training.library.exception.ApplicationException;

public class ServiceException extends ApplicationException {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, String messageKey) {
        super(message, messageKey);
    }

    public ServiceException(Throwable cause, String message) {
        super( cause, message);
    }

}

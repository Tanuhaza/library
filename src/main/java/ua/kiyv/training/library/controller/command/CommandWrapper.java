package ua.kiyv.training.library.controller.command;

import org.apache.log4j.Logger;
import ua.kiyv.training.library.controller.validate.Errors;
import ua.kiyv.training.library.exception.ApplicationException;
import ua.kiyv.training.library.exception.ServiceException;
import ua.kiyv.training.library.utils.constants.Attributes;
import ua.kiyv.training.library.utils.constants.LoggerMessages;
import ua.kiyv.training.library.utils.constants.MessageKeys;
import ua.kiyv.training.library.utils.constants.PagesPath;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * wrapper class for specific commands which can throw exception
 */
public abstract class CommandWrapper implements Command {
    private static final Logger LOGGER = Logger.getLogger(CommandWrapper.class);

    /**
     * main method which wrap all actions, which could throw some exception
     *
     * @param request  request from client
     * @param response response to client
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            return performExecute(request, response);
        } catch (ServiceException exception) {
            LOGGER.error(LoggerMessages.SERVICE_EXCEPTION_OCCURRED, exception);
            putErrorMessageInRequest(request, exception.getMessageKey());
            request.getRequestDispatcher(PagesPath.ERROR_PAGE).forward(request, response);
            exception.printStackTrace();
        } catch (ApplicationException exception) {
            LOGGER.error(LoggerMessages.APPLICATION_EXCEPTION_OCCURRED, exception);
            putErrorMessageInRequest(request, exception.getMessageKey());
            request.getRequestDispatcher(PagesPath.ERROR_PAGE).forward(request, response);
            exception.printStackTrace();
        } catch (Exception exception) {
            LOGGER.error(LoggerMessages.UNKNOWN_ERROR_OCCURED, exception);
            putErrorMessageInRequest(request, MessageKeys.UNKNOWN_ERROR_OCCURED);
            request.getRequestDispatcher(PagesPath.ERROR_PAGE).forward(request, response);
            exception.printStackTrace();
        }
        return PagesPath.FORWARD;
    }

    public void putErrorMessageInRequest(HttpServletRequest request, String messageKey) {
        Errors errors = (Errors) request.getAttribute(Attributes.ERRORS);
        if (errors == null) {
            errors = new Errors();
        }
        errors.addError(Attributes.ERROR, messageKey);
        request.setAttribute(Attributes.ERRORS, errors);
    }

    public abstract String performExecute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

}
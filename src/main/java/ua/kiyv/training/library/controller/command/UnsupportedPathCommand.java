package ua.kiyv.training.library.controller.command;


import org.apache.log4j.Logger;
import ua.kiyv.training.library.utils.constants.LoggerMessages;
import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.kiyv.training.library.utils.constants.PagesPath.REDIRECTED;


/**
 * This class represents behaviour in case of handler for requested path is not found.
 */
public class UnsupportedPathCommand implements Command {
    private static final Logger logger = Logger.getLogger(LogoutCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        logger.warn(LoggerMessages.REQUESTED_UNSUPPORTED_URI);
        response.sendRedirect(request.getContextPath() + PagesPath.HOME_PATH);
        return REDIRECTED;
    }
}

package ua.kiyv.training.library.controller.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class represents command object in command pattern.
 */
@FunctionalInterface
public interface Command {

    /**
     * @param request  request instance
     * @param response response instance
     * @return The path of view page or REDIRECTED constant in case of response.sendRedirect was performed in command
     * @throws IOException in case of troubles with redirect
     */
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}

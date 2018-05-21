package ua.kiyv.training.library.controller.command.admin.book;

import org.apache.log4j.Logger;
import ua.kiyv.training.library.controller.command.CommandWrapper;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.Impl.BookServiceImpl;
import ua.kiyv.training.library.utils.constants.Attributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.kiyv.training.library.utils.constants.Attributes.BOOK_ID;
import static ua.kiyv.training.library.utils.constants.PagesPath.*;

public class EditBookSubmitCommand extends CommandWrapper {
    private static final Logger LOGGER = Logger.getLogger(EditBookSubmitCommand.class);
    BookService bookService = BookServiceImpl.getInstance();

    @Override
    public String performExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        saveBookDataToRequest(request);
        request.getSession().setAttribute(BOOK_ID, Integer.valueOf(request.getParameter("bookId")));
        request.getRequestDispatcher(UPDATE_BOOK_PAGE).forward(request, response);
        return FORWARD;
    }

    private void saveBookDataToRequest(HttpServletRequest request) {
        request.setAttribute(Attributes.PREVIOUS_BOOK_TITLE, request.getParameter("title"));
        request.setAttribute(Attributes.PREVIOUS_BOOK_DESCRIPTION, request.getParameter("description"));
        request.setAttribute(Attributes.PREVIOUS_BOOK_QUANTITY, request.getParameter("quantity"));
        request.setAttribute(Attributes.PREVIOUS_BOOK_YEAR, request.getParameter("year"));
        request.setAttribute(Attributes.PREVIOUS_BOOK_AUTHOR_NAME, request.getParameter("first_author_name"));
        request.setAttribute(Attributes.PREVIOUS_BOOK_AUTHOR_SURNAME, request.getParameter("first_author_surname"));
        request.setAttribute(Attributes.PREVIOUS_BOOK_KEYWORDS, request.getParameter("keywords"));
        request.setAttribute(Attributes.PREVIOUS_BOOK_PICTURE_ID, request.getParameter("picture"));
    }
}

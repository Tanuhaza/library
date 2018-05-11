package ua.kiyv.training.library.controller.command.User;

import org.apache.log4j.Logger;

import ua.kiyv.training.library.controller.command.CommandWrapper;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.Impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import static ua.kiyv.training.library.utils.constants.Attributes.BOOK_ID;
import static ua.kiyv.training.library.utils.constants.Attributes.USER_ID;
import static ua.kiyv.training.library.utils.constants.PagesPath.HOME_PATH;

public class BookOrderSubmitCommand extends CommandWrapper {
    private BookService bookService = BookServiceImpl.getInstance();
    private static final Logger LOGGER = Logger.getLogger(BookOrderSubmitCommand.class);

    @Override
    public String performExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = (Integer) request.getSession().getAttribute(USER_ID);
        Integer bookId = Integer.valueOf(request.getParameter(BOOK_ID));
        bookService.createBorrowedBookByUserId(bookId, userId);
        return HOME_PATH;
    }
}

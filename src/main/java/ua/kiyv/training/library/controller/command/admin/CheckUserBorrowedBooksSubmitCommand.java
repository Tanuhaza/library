package ua.kiyv.training.library.controller.command.admin;

import org.apache.log4j.Logger;

import ua.kiyv.training.library.controller.command.CommandWrapper;
import ua.kiyv.training.library.model.BorrowedBook;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.Impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ua.kiyv.training.library.utils.constants.Attributes.USER_ID;
import static ua.kiyv.training.library.utils.constants.PagesPath.ADMIN_BORROWED_BOOKS_BY_USER_PATH;
import static ua.kiyv.training.library.utils.constants.PagesPath.FORWARD;
import static ua.kiyv.training.library.utils.constants.PagesPath.USER_BORROWED_BOOK_PAGE;

public class CheckUserBorrowedBooksSubmitCommand extends CommandWrapper {
    private static final Logger LOGGER = Logger.getLogger(CheckUserBorrowedBooksSubmitCommand.class);
    private BookService bookService = BookServiceImpl.getInstance();

    @Override
    public String performExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = Integer.valueOf(request.getParameter(USER_ID));
        return ADMIN_BORROWED_BOOKS_BY_USER_PATH + "/" + userId;
    }
}

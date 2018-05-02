package ua.kiyv.training.library.controller.command.User;

import org.apache.log4j.Logger;
import ua.kiyv.training.library.controller.CommandWrapper;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.ServiceFactory;
import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;


import static ua.kiyv.training.library.utils.constants.Attributes.USER_ID;
import static ua.kiyv.training.library.utils.constants.PagesPath.HOME_PAGE;
import static ua.kiyv.training.library.utils.constants.PagesPath.HOME_PATH;

public class BookOrderSubmitCommand extends CommandWrapper {
    private static final Logger logger = Logger.getLogger(BookOrderSubmitCommand.class);
    private BookService bookService = ServiceFactory.getInstance().createBookService();

    public BookOrderSubmitCommand() {
        super(PagesPath.LOGIN_PAGE);
    }

    @Override
    public String performExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = (Integer) request.getSession().getAttribute(USER_ID);
        System.out.println(userId);
        Integer bookId = Integer.valueOf(request.getParameter("bookId"));
        bookService.createBorrowedBookByUserId(bookId, userId);
        System.out.println("Create Order");
        return HOME_PATH;
    }
}

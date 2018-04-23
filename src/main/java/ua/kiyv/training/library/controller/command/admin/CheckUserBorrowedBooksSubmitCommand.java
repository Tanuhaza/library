package ua.kiyv.training.library.controller.command.admin;

import org.apache.log4j.Logger;
import ua.kiyv.training.library.controller.CommandWrapper;
import ua.kiyv.training.library.controller.command.book.LoadBookSubmitCommand;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.ServiceFactory;
import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckUserBorrowedBooksSubmitCommand extends CommandWrapper{
    private static final Logger logger = Logger.getLogger(LoadBookSubmitCommand.class);
    private BookService bookService = ServiceFactory.getInstance().createBookService();

    public CheckUserBorrowedBooksSubmitCommand(String nextPage) {
        super(PagesPath.LOGIN_PAGE);
    }

    @Override
    public String performExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        bookService.
        return null;
    }
}

package ua.kiyv.training.library.controller.command.admin;

import org.apache.log4j.Logger;
import ua.kiyv.training.library.controller.CommandWrapper;
import ua.kiyv.training.library.model.BorrowedBook;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.ServiceFactory;
import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ua.kiyv.training.library.utils.constants.Attributes.USER_ID;
import static ua.kiyv.training.library.utils.constants.PagesPath.FORWARD;
import static ua.kiyv.training.library.utils.constants.PagesPath.USER_BORROWED_BOOK_PAGE;

public class CheckUserBorrowedBooksSubmitCommand extends CommandWrapper{
    private static final Logger logger = Logger.getLogger( CheckUserBorrowedBooksSubmitCommand.class);
    private BookService bookService = ServiceFactory.getInstance().createBookService();

    public CheckUserBorrowedBooksSubmitCommand() {
        super(PagesPath.LOGIN_PAGE);
    }

    @Override
    public String performExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = Integer.valueOf(request.getParameter(USER_ID));
        System.out.println(userId);
        List<BorrowedBook> borrowedBooks =new ArrayList<>();
        borrowedBooks= bookService.findAllBorrowedBooksByUserId(userId);
        System.out.println(borrowedBooks);
        request.setAttribute("borrowedBooks", borrowedBooks);
        request.getRequestDispatcher(USER_BORROWED_BOOK_PAGE).forward(request,response);
        return FORWARD;
    }
}

package ua.kiyv.training.library.controller.command.admin;

import ua.kiyv.training.library.controller.command.Command;
import ua.kiyv.training.library.model.BorrowedBook;
import ua.kiyv.training.library.model.User;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.Impl.BookServiceImpl;
import ua.kiyv.training.library.service.Impl.UserServiceImpl;
import ua.kiyv.training.library.service.UserService;
import ua.kiyv.training.library.utils.ParamExtractor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static ua.kiyv.training.library.utils.constants.PagesPath.USER_BORROWED_BOOK_PAGE;

public class ViewUserBorrowedBooksCommand implements Command {

    private BookService bookService = BookServiceImpl.getInstance();
    private UserService userService = UserServiceImpl.getInstance();
    private ParamExtractor paramExtractor = new ParamExtractor();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = paramExtractor.extractSingleIntPathParam(request);
        List<BorrowedBook> borrowedBooks = bookService.findAllBorrowedBooksByUserId(userId);
        Optional<User> person = userService.findById(userId);
        if (person.isPresent()) {
            User user = person.get();
            request.setAttribute("user", user);
        }
        request.setAttribute("userId", userId);
        request.setAttribute("borrowedBooks", borrowedBooks);
        return USER_BORROWED_BOOK_PAGE;
    }
}

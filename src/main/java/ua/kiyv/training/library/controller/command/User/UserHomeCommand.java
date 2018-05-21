package ua.kiyv.training.library.controller.command.User;


import ua.kiyv.training.library.controller.command.Command;
import ua.kiyv.training.library.model.BorrowedBook;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.Impl.BookServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static ua.kiyv.training.library.utils.constants.Attributes.USER_ID;

import static ua.kiyv.training.library.utils.constants.PagesPath.HOME_PAGE;


public class UserHomeCommand implements Command {
    private BookService bookService = BookServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = (Integer) request.getSession().getAttribute(USER_ID);
        List<BorrowedBook> borrowedBooks = bookService.findAllBorrowedBooksByUserId(userId);
        request.setAttribute("borrowedBooks", borrowedBooks);
        return HOME_PAGE;
    }
}

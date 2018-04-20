package ua.kiyv.training.library.controller.command.admin;

import ua.kiyv.training.library.controller.Command;
import ua.kiyv.training.library.controller.CommandWrapper;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.Impl.BookServiceImpl;
import ua.kiyv.training.library.service.ServiceFactory;
import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService = ServiceFactory.getInstance().createBookService();
        List<Book> books =new ArrayList<>();
        books = bookService.findAllBooks();
        request.setAttribute("books",books);
        return PagesPath.ADMIN_MANAGE_PAGE;
    }
}

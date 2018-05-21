package ua.kiyv.training.library.controller.command.admin;


import ua.kiyv.training.library.controller.command.Command;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.Impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static ua.kiyv.training.library.utils.constants.PagesPath.ADMIN_MANAGE_PAGE;

public class ManageBookCommand implements Command {
    private BookService bookService = BookServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.findAllBooks();
        request.setAttribute("books", books);
        return ADMIN_MANAGE_PAGE;
    }
}

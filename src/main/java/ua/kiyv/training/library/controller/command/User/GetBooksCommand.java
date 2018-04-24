package ua.kiyv.training.library.controller.command.User;

import ua.kiyv.training.library.controller.Command;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ua.kiyv.training.library.utils.constants.PagesPath.USER_BOOKS_PAGE;

public class GetBooksCommand implements Command{
    public GetBooksCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService = ServiceFactory.getInstance().createBookService();
        List<Book> books =new ArrayList<>();
        books = bookService.findAllBooks();
        request.setAttribute("books",books);
        return USER_BOOKS_PAGE;
    }
}

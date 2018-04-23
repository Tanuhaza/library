package ua.kiyv.training.library.controller.command.book;

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

/**
 * Created by Tanya on 19.04.2018.
 */
public class DeleteBookSubmitCommand extends CommandWrapper {
    public DeleteBookSubmitCommand() {
        super(PagesPath.LOGIN_PAGE);
    }

    @Override
    public String performExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("bookId"));
        System.out.println(request.getParameter("bookId"));
        BookService bookService = ServiceFactory.getInstance().createBookService();
        bookService.delete(id);
//        List<Book> books =new ArrayList<>();
//        books = bookService.findAllBooks();
//        request.setAttribute("books",books);
        return PagesPath.MANAGE_PATH;
    }
}

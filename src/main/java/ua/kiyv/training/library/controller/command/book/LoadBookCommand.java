package ua.kiyv.training.library.controller.command.book;

import ua.kiyv.training.library.controller.Command;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.model.Genre;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.ServiceFactory;
import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadBookCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        BookService bookService = ServiceFactory.getInstance().createBookService();
//        List<Genre> genres =new ArrayList<>();
//        genres = bookService.findAllGenres();
//        request.getSession().setAttribute("genres",genres);
        return PagesPath.LOAD_BOOK_PAGE;
    }
}

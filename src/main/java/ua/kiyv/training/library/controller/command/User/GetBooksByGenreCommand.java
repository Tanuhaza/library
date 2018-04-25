package ua.kiyv.training.library.controller.command.User;

import ua.kiyv.training.library.controller.Command;
import ua.kiyv.training.library.dao.BookDao;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.ServiceFactory;
import ua.kiyv.training.library.utils.ParamExtractor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ua.kiyv.training.library.utils.constants.PagesPath.USER_BOOKS_BY_GENRE_PAGE;

public class GetBooksByGenreCommand implements Command {
    ParamExtractor paramExtractor = new ParamExtractor();
    public GetBooksByGenreCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int genreId = paramExtractor.extractSingleIntPathParam(request);
        System.out.println("GENRE_ID  "+genreId);

        List<Book> booksByGenre=new ArrayList<>();
        booksByGenre = ServiceFactory.getInstance().createBookService().findByGenreId(genreId);
        request.setAttribute("booksByGenre", booksByGenre);

        return USER_BOOKS_BY_GENRE_PAGE;
    }
}

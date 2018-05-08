package ua.kiyv.training.library.controller.command.User;


import ua.kiyv.training.library.controller.command.Command;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.service.BookService;

import ua.kiyv.training.library.service.Impl.BookServiceImpl;
import ua.kiyv.training.library.service.Impl.UserServiceImpl;
import ua.kiyv.training.library.service.UserService;
import ua.kiyv.training.library.utils.ParamExtractor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.kiyv.training.library.utils.constants.PagesPath.USER_BOOK_DESCRIPTION_PAGE;

public class BookDescriptionCommand implements Command {
    private ParamExtractor paramExtractor = new ParamExtractor();
    private BookService bookService = BookServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = paramExtractor.extractSingleIntPathParam(request);
        Book book =bookService.findById(bookId);
        request.setAttribute("book", book);
        return USER_BOOK_DESCRIPTION_PAGE ;
    }
}

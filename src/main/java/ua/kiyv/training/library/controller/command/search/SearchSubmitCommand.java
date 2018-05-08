package ua.kiyv.training.library.controller.command.search;


import ua.kiyv.training.library.controller.command.CommandWrapper;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.Impl.BookServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ua.kiyv.training.library.utils.constants.PagesPath.*;

public class SearchSubmitCommand extends CommandWrapper {
    private BookService bookService = BookServiceImpl.getInstance();
    private  Map<String ,List<Book>> commandSearch =new HashMap<>();


    @Override
    public String performExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filterValue = request.getParameter("filter");
        String searchValue = request.getParameter("searchValue");
        commandSearch.put("title",bookService.findByTitle(searchValue));
        commandSearch.put("author",bookService.findByAuthor(searchValue));
//        commandSearch.put("keywords",bookService.findByKeywords(searchValue));
        List<Book> books = commandSearch.get(filterValue);
        request.setAttribute("books",books);
request.getRequestDispatcher(USER_BOOKS_PAGE).forward(request,response);
        return FORWARD;
    }
}

package ua.kiyv.training.library.controller.command.search;


import ua.kiyv.training.library.controller.command.CommandWrapper;
import ua.kiyv.training.library.dao.By;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.model.Role;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.Impl.BookServiceImpl;
import ua.kiyv.training.library.utils.constants.Attributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ua.kiyv.training.library.utils.constants.Attributes.*;
import static ua.kiyv.training.library.utils.constants.PagesPath.*;

public class SearchSubmitCommand extends CommandWrapper {
    private BookService bookService = BookServiceImpl.getInstance();
    private Map<String, By> commandSearch = new HashMap<>();

    {
        commandSearch.put(TITLE, By.byTitle());
        commandSearch.put(AUTHOR, By.byAuthor());
        commandSearch.put(KEYWORDS, By.byKeywords());
    }

    @Override
    public String performExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filterValue = request.getParameter(FILTER);
        String searchValue = request.getParameter(SEARCH_VALUE);
        Role role = (Role) request.getSession().getAttribute(Attributes.USER_ROLE);
        By query = commandSearch.get(filterValue);
        List<Book> books = bookService.findBy(searchValue, query);
        request.setAttribute("books", books);
        if (role == Role.USER) {
            request.getRequestDispatcher(USER_BOOKS_PAGE).forward(request, response);
        }
        request.getRequestDispatcher(ADMIN_MANAGE_PAGE).forward(request, response);
        return FORWARD;
    }


}

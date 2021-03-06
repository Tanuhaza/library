package ua.kiyv.training.library.controller.command.admin.book;


import ua.kiyv.training.library.controller.command.CommandWrapper;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.Impl.BookServiceImpl;
import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.kiyv.training.library.utils.constants.Attributes.BOOK_ID;
import static ua.kiyv.training.library.utils.constants.PagesPath.ADMIN_MANAGE_PATH;

public class DeleteBookSubmitCommand extends CommandWrapper {
    BookService bookService = BookServiceImpl.getInstance();

    @Override
    public String performExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter(BOOK_ID));
        bookService.delete(id);
        return ADMIN_MANAGE_PATH;
    }
}

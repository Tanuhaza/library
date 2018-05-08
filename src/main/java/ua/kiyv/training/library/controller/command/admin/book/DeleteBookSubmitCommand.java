package ua.kiyv.training.library.controller.command.admin.book;


import ua.kiyv.training.library.controller.command.CommandWrapper;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.Impl.BookServiceImpl;
import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tanya on 19.04.2018.
 */
public class DeleteBookSubmitCommand extends CommandWrapper {
    BookService bookService = BookServiceImpl.getInstance();

    @Override
    public String performExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("bookId"));
        System.out.println(request.getParameter("bookId"));
        bookService.delete(id);
        return PagesPath.ADMIN_MANAGE_PATH;
    }
}

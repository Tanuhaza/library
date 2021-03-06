package ua.kiyv.training.library.controller.command.admin.book;


import ua.kiyv.training.library.controller.command.Command;
import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoadBookCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return PagesPath.LOAD_BOOK_PAGE;
    }
}

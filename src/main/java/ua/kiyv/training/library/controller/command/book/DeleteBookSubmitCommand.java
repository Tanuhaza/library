package ua.kiyv.training.library.controller.command.book;

import ua.kiyv.training.library.controller.CommandWrapper;
import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tanya on 19.04.2018.
 */
public class DeleteBookSubmitCommand extends CommandWrapper {
    public DeleteBookSubmitCommand() {
        super(PagesPath.LOGIN_PAGE);
    }

    @Override
    public String performExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return null;
    }
}

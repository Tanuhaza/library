package ua.kiyv.training.library.controller.command;


import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        return PagesPath.LOGIN_PAGE;
    }
}

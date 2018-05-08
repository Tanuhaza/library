package ua.kiyv.training.library.controller.command.login;



import ua.kiyv.training.library.controller.command.Command;
import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return PagesPath.LOGIN_PAGE;
    }
}

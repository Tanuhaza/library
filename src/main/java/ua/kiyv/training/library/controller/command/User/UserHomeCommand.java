package ua.kiyv.training.library.controller.command.User;

import ua.kiyv.training.library.controller.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.kiyv.training.library.utils.constants.PagesPath.HOME_PAGE;

public class UserHomeCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return HOME_PAGE;
    }
}

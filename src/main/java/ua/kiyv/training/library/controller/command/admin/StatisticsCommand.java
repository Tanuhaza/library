package ua.kiyv.training.library.controller.command.admin;

import ua.kiyv.training.library.controller.Command;
import ua.kiyv.training.library.controller.CommandWrapper;
import ua.kiyv.training.library.model.User;
import ua.kiyv.training.library.service.ServiceFactory;
import ua.kiyv.training.library.service.UserService;
import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ua.kiyv.training.library.utils.constants.PagesPath.ADMIN_STATISTICS_PAGE;

public class StatisticsCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = ServiceFactory.getInstance().createUserService();
        List<User> users =new ArrayList();
        users=userService.findAll();
        request.setAttribute("users",users);
        return ADMIN_STATISTICS_PAGE;
    }
}

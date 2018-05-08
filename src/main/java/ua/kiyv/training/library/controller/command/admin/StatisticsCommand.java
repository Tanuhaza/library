package ua.kiyv.training.library.controller.command.admin;


import ua.kiyv.training.library.controller.command.Command;
import ua.kiyv.training.library.model.User;

import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.Impl.BookServiceImpl;
import ua.kiyv.training.library.service.Impl.UserServiceImpl;
import ua.kiyv.training.library.service.UserService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ua.kiyv.training.library.utils.constants.PagesPath.ADMIN_STATISTICS_PAGE;

public class StatisticsCommand implements Command {
   UserService userService = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users =userService.findAll();
        request.setAttribute("users",users);
        return ADMIN_STATISTICS_PAGE;
    }
}

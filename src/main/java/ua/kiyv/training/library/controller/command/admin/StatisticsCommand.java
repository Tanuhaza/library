package ua.kiyv.training.library.controller.command.admin;

import ua.kiyv.training.library.controller.Command;
import ua.kiyv.training.library.controller.CommandWrapper;
import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.kiyv.training.library.utils.constants.PagesPath.ADMIN_STATISTICS_PAGE;

public class StatisticsCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return ADMIN_STATISTICS_PAGE;
    }
}

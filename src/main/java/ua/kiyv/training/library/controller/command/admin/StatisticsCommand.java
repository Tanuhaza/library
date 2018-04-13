package ua.kiyv.training.library.controller.command.admin;

import ua.kiyv.training.library.controller.Command;
import ua.kiyv.training.library.controller.CommandWrapper;
import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StatisticsCommand extends CommandWrapper {
    public StatisticsCommand() {super(PagesPath.ADMIN_STATISTICS_PAGE);}

    @Override
    public String performExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return null;
    }
}

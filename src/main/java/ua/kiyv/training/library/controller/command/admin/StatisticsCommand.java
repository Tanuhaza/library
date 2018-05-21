package ua.kiyv.training.library.controller.command.admin;


import ua.kiyv.training.library.controller.command.Command;
import ua.kiyv.training.library.model.User;

import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.Impl.BookServiceImpl;
import ua.kiyv.training.library.service.Impl.UserServiceImpl;
import ua.kiyv.training.library.service.UserService;
import ua.kiyv.training.library.utils.ParamExtractor;
import ua.kiyv.training.library.utils.constants.Attributes;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ua.kiyv.training.library.utils.constants.Attributes.CURRENT_PAGE;
import static ua.kiyv.training.library.utils.constants.Attributes.LAST_PAGE;
import static ua.kiyv.training.library.utils.constants.Attributes.PAGE;
import static ua.kiyv.training.library.utils.constants.PagesPath.ADMIN_STATISTICS_PAGE;

public class StatisticsCommand implements Command {
    ParamExtractor paramExtractor = new ParamExtractor();
    private static final int itemsPerPage = 3;
    private static final int FIRST = 1;
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        placeNecessaryDataToRequest(request);
        return ADMIN_STATISTICS_PAGE;
    }

    protected void placeNecessaryDataToRequest(HttpServletRequest request) {

        int currentPageNumber = getPageNumberFromRequest(request);
        int ordersStartFrom = calculateItemOffset(currentPageNumber);
        List<User> users;
        users = userService.getAllWithLimitPerPage(ordersStartFrom, itemsPerPage);
        int lastPageNumber = calculateLastPageNumber(userService.countAllUsers());
        while (currentPageNumber > lastPageNumber) {
            currentPageNumber = lastPageNumber;
            ordersStartFrom = calculateItemOffset(currentPageNumber);
            users = userService.getAllWithLimitPerPage(ordersStartFrom, itemsPerPage);
            lastPageNumber = calculateLastPageNumber(userService.countAllUsers());
        }
        request.setAttribute(Attributes.USERS, users);
        request.setAttribute(CURRENT_PAGE, currentPageNumber);
        request.setAttribute(LAST_PAGE, lastPageNumber);
    }

    private int calculateItemOffset(int pageNumber) {
        return (pageNumber - FIRST) * itemsPerPage;
    }

    private int calculateLastPageNumber(int totalCount) {
        int lastPageNumber = (int) Math.ceil(1.0 * totalCount / itemsPerPage);
        return (lastPageNumber == 0) ? FIRST : lastPageNumber;
    }

    private int getPageNumberFromRequest(HttpServletRequest request) {
        if (request.getParameter(PAGE) == null) {
            return FIRST;
        }
        int requestedPageNumber = paramExtractor.extractIntFromString(request.getParameter(PAGE));
        if (requestedPageNumber < FIRST) {
            requestedPageNumber = FIRST;
        }
        return requestedPageNumber;
    }
}

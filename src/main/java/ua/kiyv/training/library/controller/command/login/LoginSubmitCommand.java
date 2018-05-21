package ua.kiyv.training.library.controller.command.login;


import org.apache.log4j.Logger;
import ua.kiyv.training.library.controller.command.CommandWrapper;
import ua.kiyv.training.library.controller.validate.Errors;
import ua.kiyv.training.library.controller.validate.LoginValidator;
import ua.kiyv.training.library.model.Genre;
import ua.kiyv.training.library.model.Role;
import ua.kiyv.training.library.model.User;
import ua.kiyv.training.library.model.dto.LoginData;
import ua.kiyv.training.library.service.BookService;

import ua.kiyv.training.library.service.Impl.BookServiceImpl;
import ua.kiyv.training.library.service.Impl.UserServiceImpl;
import ua.kiyv.training.library.service.UserService;
import ua.kiyv.training.library.utils.constants.Attributes;
import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class LoginSubmitCommand extends CommandWrapper {
    private static final Logger LOGGER = Logger.getLogger(LoginSubmitCommand.class);
    private static final String PARAM_LOGIN = "login_name";
    private static final String PARAM_PASSWORD = "login_password";

    private UserService userService = UserServiceImpl.getInstance();
    private BookService bookService = BookServiceImpl.getInstance();
    private LoginValidator loginValidator;

    public LoginSubmitCommand() {
        loginValidator = new LoginValidator();
    }

    @Override
    public String performExecute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Errors errors = new Errors();
        saveLoginDataToRequest(request);
        String pageToGo = PagesPath.LOGIN_PATH;

        LoginData loginData = extractLoginData(request);
        errors.addErrors(loginValidator.validate(loginData).getErrors());
        if (errors.hasErrors()) {
            processErrors(request, errors);
            request.getRequestDispatcher(PagesPath.LOGIN_PAGE).forward(request, response);
            return PagesPath.FORWARD;
        }

        String login = loginData.getEmail();
        String password = userService.encrypt(loginData.getPassword());
        Optional<User> user = userService.getUserByEmailPassword(login, password);
        if (user.isPresent()) {
            User person = user.get();
            pageToGo = getResultPageByUserRole(person);
            request.getSession().setAttribute(Attributes.USER_ID, person.getId());
            request.getSession().setAttribute(Attributes.USER_ROLE, person.getRole());
            List<Genre> genres = bookService.findAllGenres();
            request.getSession().setAttribute("genres", genres);
        }
        clearLoginDataFromRequest(request);
        return pageToGo;
    }

    private LoginData extractLoginData(HttpServletRequest request) {
        return new LoginData.Builder()
                .email(request.getParameter(PARAM_LOGIN))
                .password(request.getParameter(PARAM_PASSWORD))
                .build();
    }

    private String getResultPageByUserRole(User user) {
        String result = PagesPath.HOME_PATH;
        if (user.getRole() == Role.ADMIN) {
            result = PagesPath.ADMIN_PATH;
        }
        return result;
    }

    private void processErrors(HttpServletRequest request, Errors errors) {
        LOGGER.error("Wrong input data in login");
        request.setAttribute(Attributes.ERRORS, errors);
    }

    private void saveLoginDataToRequest(HttpServletRequest request) {
        request.setAttribute(Attributes.PREVIOUS_LOGIN, request.getParameter(PARAM_LOGIN));
        request.setAttribute(Attributes.PREVIOUS_PASSWORD, request.getParameter(PARAM_PASSWORD));
    }

    private void clearLoginDataFromRequest(HttpServletRequest request) {
        request.removeAttribute(Attributes.PREVIOUS_LOGIN);
        request.removeAttribute(Attributes.PREVIOUS_PASSWORD);
    }
}
package ua.kiyv.training.library.controller.command.login;

import org.apache.log4j.Logger;

import ua.kiyv.training.library.controller.command.CommandWrapper;
import ua.kiyv.training.library.controller.validate.Errors;
import ua.kiyv.training.library.controller.validate.UserValidator;
import ua.kiyv.training.library.model.Role;
import ua.kiyv.training.library.model.User;
import ua.kiyv.training.library.model.dto.RegisterData;

import ua.kiyv.training.library.service.Impl.UserServiceImpl;
import ua.kiyv.training.library.service.UserService;
import ua.kiyv.training.library.utils.constants.Attributes;
import ua.kiyv.training.library.utils.constants.MessageKeys;
import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterSubmitCommand extends CommandWrapper {
    private static final Logger logger = Logger.getLogger(RegisterSubmitCommand.class);
    private UserService userService = UserServiceImpl.getInstance();
    private UserValidator userValidator;

    public RegisterSubmitCommand() {
        userValidator = new UserValidator();
    }

    @Override
    public String performExecute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Errors errors = new Errors();
        saveRegisterDataToRequest(request);
        RegisterData registerData = extractRegisterData(request);
        errors.addErrors(userValidator.validate(registerData).getErrors());
        if (errors.hasErrors()) {
            processErrors(request, errors);
            request.getRequestDispatcher(PagesPath.LOGIN_PAGE).forward(request, response);
            return PagesPath.FORWARD;
        }
        User user = extractUserFromRegisterData(registerData);
        userService.create(user);
        logger.info(String.format("User %s %s was successfully registered", registerData.getFirstName(), registerData.getLastName()));
        clearRegisterDataFromRequest(request);
        request.setAttribute(Attributes.CONFIRM_MESSAGE, MessageKeys.SUCCESSFUL_REGISTER);
        request.getRequestDispatcher(PagesPath.CONFIRMATION_PAGE).forward(request, response);
        return PagesPath.FORWARD;
    }

    private RegisterData extractRegisterData(HttpServletRequest request) {
        RegisterData.Builder builder = RegisterData.builder()
                .firstName(request.getParameter("name"))
                .lastName(request.getParameter("surname"))
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .phone(request.getParameter("phone"));
        return builder.build();
    }

    private void processErrors(HttpServletRequest request, Errors errors) {
        logger.error("Wrong input data in registration");
        request.setAttribute(Attributes.ERRORS, errors);
    }

    private void saveRegisterDataToRequest(HttpServletRequest request) {
        request.setAttribute(Attributes.PREVIOUS_USER_NAME, request.getParameter("name"));
        request.setAttribute(Attributes.PREVIOUS_USER_SURNAME, request.getParameter("surname"));
        request.setAttribute(Attributes.PREVIOUS_USER_EMAIL, request.getParameter("email"));
        request.setAttribute(Attributes.PREVIOUS_USER_LOGIN, request.getParameter("phone"));
        request.setAttribute(Attributes.PREVIOUS_USER_PASSWORD, request.getParameter("password"));
        request.setAttribute(Attributes.TAB, Attributes.REGISTER_TAB);
    }

    private void clearRegisterDataFromRequest(HttpServletRequest request) {
        request.removeAttribute(Attributes.PREVIOUS_USER_NAME);
        request.removeAttribute(Attributes.PREVIOUS_USER_SURNAME);
        request.removeAttribute(Attributes.PREVIOUS_USER_EMAIL);
        request.removeAttribute(Attributes.PREVIOUS_USER_LOGIN);
        request.removeAttribute(Attributes.PREVIOUS_USER_PASSWORD);
        request.removeAttribute(Attributes.TAB);
    }

    private User extractUserFromRegisterData(RegisterData registerData) {
        return new User.Builder()
                .setFirstName(registerData.getFirstName())
                .setLastName(registerData.getLastName())
                .setPassword(userService.encrypt(registerData.getPassword()))
                .setPhone(registerData.getPhone())
                .setEmail(registerData.getEmail())
                .setRole(Role.USER)
                .build();
    }
}
package ua.kiyv.training.library.controller.filter;

import org.apache.log4j.Logger;
import ua.kiyv.training.library.model.Role;

import ua.kiyv.training.library.utils.constants.Attributes;
import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

/**
 * This class is authorization filter.
 * Filter checks every user request, to find out his permissions.
 * If user don't have permissions, the filter forward user to login page.
 */
@WebFilter(filterName = "Auth",urlPatterns ="/library/*")
public class AuthFilter implements Filter {
    private static final Logger logger = Logger.getLogger(AuthFilter.class);
    private static final String USER_NOT_AUTHORIZED = "User isn't authorized";

    private static EnumMap<Role, Authorizer> authorizeByRole = new EnumMap<>(Role.class);

    static {
        authorizeByRole.put(Role.USER, new UserAuthorizer());
        authorizeByRole.put(Role.ADMIN, new AdminAuthorizer());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = ((HttpServletRequest) request);
        HttpServletResponse res = ((HttpServletResponse) response);
        HttpSession session = req.getSession();
        String uri = req.getRequestURI();
        System.out.println(uri);
        req.setCharacterEncoding(Attributes.UTF_8);
        res.setContentType("text/html");

//        if (session == null || session.isNew()) {
//            req.getRequestDispatcher("index.jsp").forward(request, response);
//        }

        Integer userId = (Integer) session.getAttribute(Attributes.USER_ID);
        Role role = (Role) session.getAttribute(Attributes.USER_ROLE);

        if (!checkUserPermissions(uri, userId, role)) {
            System.out.println("AuthFilter.class REDIRECT TO LOGIN");
            res.sendRedirect(PagesPath.LOGIN_PATH);
            logger.info(String.format(USER_NOT_AUTHORIZED));
            return;
        }

        chain.doFilter(request, response);
    }

    /**
     * this method check user permissions
     *
     * @param uri
     * @param userId
     * @param role
     * @return
     */
    private boolean checkUserPermissions(String uri, Object userId, Role role) {
        if (uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".png")) {
            return true;
        }
        Authorizer authorizer = authorizeByRole.getOrDefault(role, new AnonymAuthorizer());
        return authorizer.check(uri, userId);
    }

    private interface Authorizer {
        boolean check(String uri, Object userId);
    }

    private static class UserAuthorizer implements Authorizer {
        public boolean check(String uri, Object userId) {
            return userId != null && !uri.startsWith(PagesPath.ADMIN_PATH);
        }
    }

    private static class AdminAuthorizer implements Authorizer {
        public boolean check(String uri, Object userId) {
            return (userId != null && (uri.startsWith(PagesPath.ADMIN_PATH)));
//                    || uri.startsWith(PagesPath.LOGIN_PATH) ||
//                    uri.startsWith(PagesPath.REGISTER_PATH));
        }
    }

    private class AnonymAuthorizer implements Authorizer {
        public boolean check(String uri, Object userId) {
            return uri.startsWith(PagesPath.LOGIN_PATH) ||
                    uri.startsWith(PagesPath.REGISTER_PATH);
        }
    }

    /**
     * method which perform filter initialization
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * method, which will be performed before filter destroy
     */
    @Override
    public void destroy() {

    }
}
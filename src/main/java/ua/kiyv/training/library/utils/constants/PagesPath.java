package ua.kiyv.training.library.utils.constants;

/**
 * This class contains paths to jsp pages and URLs, which are supported
 */
public final class PagesPath {
    public static final String REDIRECTED = "REDIRECTED";
    public static final String FORWARD = "FORWARD";

    public static final String VIEW_JSP_CLASSPATH = "/WEB-INF/view/jsp/";

    public static final String INDEX_PATH = "/";

    public static final String HOME_PATH = "/library/user";
    public static final String ADMIN_PATH = "/library/admin";
    public static final String LOGIN_PATH = "/library/login";
    public static final String REGISTER_PATH = "/library/register";
    public static final String LOGOUT_PATH = "/library/logout";
    public static final String ADMIN_STATISTICS_PATH = "/library/admin/statistics";
    public static final String ADMIN_MANAGE_PATH = "/library/admin/manage";
    public static final String ADMIN_BOOK_DELETE_PATH = "/library/admin/book/delete";
    public static final String ADMIN_BOOK_EDIT_PATH = "/library/admin/book/edit";
    public static final String ADMIN_BOOK_LOAD_PATH = "/library/admin/book/load";
    public static final String ADMIN_BOOK_UPDATE_PATH = "/library/admin/book/update";
    public static final String ADMIN_BORROWED_BOOKS_BY_USER_PATH = "/library/admin/borrowed/books/user";
    public static final String ADMIN_VIEW_BORROWED_BOOKS_BY_USER_PATH = "/library/admin/borrowed/books/user/id";
    public static final String ADMIN_BORROWED_BOOK_DELETE_BY_USER_PATH = "/library/admin/borrowed/book/delete";

    public static final String USER_BOOKS_PATH = "/library/user/books";
    public static final String USER_BOOKS_BY_GENRE_PATH = "/library/user/books/genre/id";
    public static final String USER_ORDER = "/library/user/book/order";
    public static final String USER_BOOK_DESCRIPTION_PATH = "/library/user/book/id";
    public static final String SEARCH_PATH = "/library/search";


    public static final String LOGIN_PAGE = VIEW_JSP_CLASSPATH + "loginPage.jsp";
    public static final String CONFIRMATION_PAGE = VIEW_JSP_CLASSPATH + "confirmation.jsp";
    public static final String ERROR_PAGE = VIEW_JSP_CLASSPATH + "error.jsp";

    public static final String ADMIN_HOME_PAGE = VIEW_JSP_CLASSPATH + "admin/adminHome.jsp";
    public static final String ADMIN_STATISTICS_PAGE = VIEW_JSP_CLASSPATH + "admin/statisticsPage.jsp";
    public static final String ADMIN_MANAGE_PAGE = VIEW_JSP_CLASSPATH + "admin/managePage.jsp";
    public static final String LOAD_BOOK_PAGE = VIEW_JSP_CLASSPATH + "book/loadBook.jsp";
    public static final String UPDATE_BOOK_PAGE = VIEW_JSP_CLASSPATH + "book/updateBook.jsp";
    public static final String USER_BORROWED_BOOK_PAGE = VIEW_JSP_CLASSPATH + "book/userBorrowedBooks.jsp";

    public static final String USER_BOOKS_PAGE = VIEW_JSP_CLASSPATH + "user/getBooksPage.jsp";
    public static final String USER_BOOKS_BY_GENRE_PAGE = VIEW_JSP_CLASSPATH + "/user/getBooksByGenrePage.jsp";
    public static final String USER_BOOK_DESCRIPTION_PAGE = VIEW_JSP_CLASSPATH + "/user/bookDescriptionPage.jsp";

    public static final String HOME_PAGE = VIEW_JSP_CLASSPATH + "user/userHome.jsp";
}





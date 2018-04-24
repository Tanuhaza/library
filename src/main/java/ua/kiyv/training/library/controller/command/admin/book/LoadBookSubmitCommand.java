package ua.kiyv.training.library.controller.command.admin.book;

import org.apache.log4j.Logger;
import ua.kiyv.training.library.controller.CommandWrapper;
import ua.kiyv.training.library.controller.validate.BookValidator;
import ua.kiyv.training.library.controller.validate.Errors;
import ua.kiyv.training.library.model.Author;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.model.dto.BookData;
import ua.kiyv.training.library.service.AuthorService;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.ServiceFactory;
import ua.kiyv.training.library.utils.constants.Attributes;
import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Tanya on 19.04.2018.
 */
public class LoadBookSubmitCommand extends CommandWrapper {
    private static final Logger logger = Logger.getLogger(LoadBookSubmitCommand.class);
    private BookService bookService = ServiceFactory.getInstance().createBookService();
    private AuthorService authorService = ServiceFactory.getInstance().createAuthorService();
    private BookValidator bookValidator;

    public LoadBookSubmitCommand() {
        super(PagesPath.LOGIN_PAGE);
        bookValidator = new BookValidator();
    }

    @Override
    public String performExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Errors errors = new Errors();
        BookData bookdata = extractBookDate(request);
        saveBookDataToRequest(request);
        errors.addErrors(bookValidator.validate(bookdata).getErrors());
        if (errors.hasErrors()) {
            System.out.println("has errors");
            processErrors(request, errors);
            request.getRequestDispatcher(PagesPath.LOAD_BOOK_PAGE).forward(request, response);
            return PagesPath.FORWARD;
        }
        Book book = extractBookFromRegisterData(bookdata);
        Author author = extractAuthorFromRegisterData(bookdata);
        bookService.create(book);
        authorService.create(author);
        bookService.matchBookAuthor(book, author);
        System.out.println("Save Date to DB");
        logger.info(String.format("User %s %s was successfully registered", book.getTitle(), author.getFirstName(), author.getLastName()));
        return PagesPath.ADMIN_MANAGE_PATH;
    }

    private BookData extractBookDate(HttpServletRequest request) {
        return new BookData.Builder()
                .setTitle(request.getParameter("title"))
                .setDiscription(request.getParameter("description"))
                .setPictureId(request.getParameter("picture"))
                .setAvaliable(Boolean.parseBoolean(request.getParameter("isAvailable")))
                .setQuantity(request.getParameter("quantity"))
                .setYear(request.getParameter("year"))
                .setGenreId(Integer.parseInt(request.getParameter("genre")))
                .setKeywords(request.getParameter("keywords"))
                .setFirstAuthorName(request.getParameter("first_author_name"))
                .setFirstAuthorSurname(request.getParameter("first_author_surname"))
                .build();
    }

    private void processErrors(HttpServletRequest request, Errors errors) {
        logger.error("Wrong input data in registration");
        request.setAttribute(Attributes.ERRORS, errors);
    }

    private Book extractBookFromRegisterData(BookData bookData) {
        return new Book.Builder()
                .setTitle(bookData.getTitle())
                .setDiscription(bookData.getDescription())
                .setPictureId(bookData.getPictureId())
                .setAvaliable(bookData.isAvaliable())
                .setQuantity(Integer.parseInt(bookData.getQuantity()))
                .setYear(Integer.parseInt(bookData.getYear()))
                .setGenreId(bookData.getGenreId())
                .setKeywords(bookData.getKeywords())
                .build();
    }

    private Author extractAuthorFromRegisterData(BookData bookData) {
        return new Author.Builder()
                .setFirstName(bookData.getFirstAuthorName())
                .setLastName(bookData.getFirstAuthorSurname())
                .build();
    }

    private void saveBookDataToRequest(HttpServletRequest request) {
        request.setAttribute(Attributes.PREVIOUS_BOOK_TITLE, request.getParameter("title"));
        request.setAttribute(Attributes.PREVIOUS_BOOK_DESCRIPTION, request.getParameter("description"));
        request.setAttribute(Attributes.PREVIOUS_BOOK_QUANTITY, request.getParameter("quantity"));
        request.setAttribute(Attributes.PREVIOUS_BOOK_YEAR, request.getParameter("year"));
        request.setAttribute(Attributes.PREVIOUS_BOOK_AUTHOR_NAME, request.getParameter("first_author_name"));
        request.setAttribute(Attributes.PREVIOUS_BOOK_AUTHOR_SURNAME, request.getParameter("first_author_surname"));
        request.setAttribute(Attributes.PREVIOUS_BOOK_KEYWORDS, request.getParameter("keywords"));
        request.setAttribute(Attributes.PREVIOUS_BOOK_PICTURE_ID, request.getParameter("picture"));
    }

}

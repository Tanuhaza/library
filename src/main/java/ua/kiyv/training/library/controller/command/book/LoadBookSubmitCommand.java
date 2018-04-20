package ua.kiyv.training.library.controller.command.book;

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
import ua.kiyv.training.library.utils.constants.MessageKeys;
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
    }

    @Override
    public String performExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Errors errors = new Errors();
       BookData bookdata = extractBookDate(request);
        errors.addErrors(bookValidator.validate(bookdata).getErrors());
        if (errors.hasErrors()) {
            processErrors(request, errors);
            request.getRequestDispatcher(PagesPath.LOAD_BOOK_PAGE).forward(request, response);
            return PagesPath.FORWARD;
        }
        Book book =extractBookFromRegisterData(bookdata);
        Author author = extractAuthorFromRegisterData(bookdata);
        bookService.create(book);
        authorService.create(author);
        bookService.matchBookAuthor(book,author);
        logger.info(String.format("User %s %s was successfully registered", book.getTitle(), author.getFirstName(),author.getLastName()));
        request.setAttribute(Attributes.CONFIRM_MESSAGE, MessageKeys.SUCCESSFUL_LOAD_BOOK);
        request.getRequestDispatcher(PagesPath.CONFIRMATION_PAGE).forward(request, response);
        return PagesPath.FORWARD;
    }

    private BookData extractBookDate(HttpServletRequest request) {
        return new BookData.Builder()
                .setTitle(request.getParameter("title"))
                .setDiscription(request.getParameter("description"))
                .setPictureId(request.getParameter("picture"))
                .setAvaliable(Boolean.valueOf(request.getParameter("isAvailable")))
                .setQuantity(Integer.valueOf(request.getParameter("quantity")))
                .setYear(Integer.valueOf(request.getParameter("year")))
                .setGenreId(Integer.valueOf(request.getParameter("genre")))
                .setKeywords(request.getParameter("keywords"))
                .setRate(Integer.valueOf(request.getParameter("rate")))
                .setFirstAuthorName(request.getParameter("first_author_surname"))
                .setFirstAuthorSurname(request.getParameter("first_author_surname"))
                .build();
    }
    private void processErrors(HttpServletRequest request, Errors errors){
        logger.error("Wrong input data in registration");
        request.setAttribute(Attributes.ERRORS, errors);
    }

    private Book extractBookFromRegisterData(BookData bookData){
        return new Book.Builder()
                .setTitle(bookData.getTitle())
                .setDiscription(bookData.getDescription())
                .setPictureId(bookData.getPictureId())
                .setAvaliable(bookData.isAvaliable())
                .setQuantity(bookData.getQuantity())
                .setYear(bookData.getYear())
                .setGenreId(bookData.getGenreId())
                .setKeywords(bookData.getKeywords())
                .setRate(bookData.getRate())
                .build();
    }
    private Author extractAuthorFromRegisterData(BookData bookData){
        return new Author.Builder()
                .setFirstName(bookData.getFirstAuthorName())
                .setLastName(bookData.getFirstAuthorSurname())
                .build();
    }

}

package ua.kiyv.training.library.controller.command.User;

import org.apache.log4j.Logger;
import ua.kiyv.training.library.controller.CommandWrapper;
import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.model.BorrowedBook;
import ua.kiyv.training.library.model.dto.BookData;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.ServiceFactory;
import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import static ua.kiyv.training.library.utils.constants.Attributes.BOOK_ID;
import static ua.kiyv.training.library.utils.constants.Attributes.USER_ID;

public class BookOrderSubmitCommand extends CommandWrapper {
    private static final Logger logger = Logger.getLogger(BookOrderSubmitCommand.class);
    private BookService bookService = ServiceFactory.getInstance().createBookService();
    public BookOrderSubmitCommand() {
        super(PagesPath.LOGIN_PAGE);
    }

    @Override
    public String performExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId =(Integer) request.getSession().getAttribute(USER_ID);
        Integer bookId = Integer.valueOf(request.getParameter("bookId"));
        Book book = bookService.findById(bookId);
        Date d =new Date();
        System.out.println(d);
        Calendar c =Calendar.getInstance() ;
        c.setTime(d);
        c.add(Calendar.MONTH,1);
        Date d2=c.getTime();
        System.out.println(d2);

       bookService.createBorrowedBookByUserId(book,userId);
        return null;
    }

//    private Book extractBookDate(HttpServletRequest request) {
//        return new Book.Builder()
//                .setId((Integer)request.getSession().getAttribute(BOOK_ID))
//                .setTitle(request.getParameter("title"))
//                .setDiscription(request.getParameter("description"))
//                .setPictureId(request.getParameter("picture"))
//                .setAvaliable(Boolean.parseBoolean(request.getParameter("isAvailable")))
//                .setQuantity(Integer.parseInt(request.getParameter("quantity")))
//                .setYear(Integer.parseInt(request.getParameter("year")))
//                .setGenreId(Integer.parseInt(request.getParameter("genre")))
//                .setKeywords(request.getParameter("keywords"))
//                .build();
//    }
}

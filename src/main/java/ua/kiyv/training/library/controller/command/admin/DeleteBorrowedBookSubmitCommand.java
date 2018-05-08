package ua.kiyv.training.library.controller.command.admin;


import ua.kiyv.training.library.controller.command.CommandWrapper;
import ua.kiyv.training.library.model.BorrowedBook;
import ua.kiyv.training.library.service.BookService;
import ua.kiyv.training.library.service.Impl.BookServiceImpl;

import ua.kiyv.training.library.utils.constants.PagesPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ua.kiyv.training.library.utils.constants.Attributes.BOOK_ID;
import static ua.kiyv.training.library.utils.constants.Attributes.USER_ID;

import static ua.kiyv.training.library.utils.constants.PagesPath.FORWARD;
import static ua.kiyv.training.library.utils.constants.PagesPath.USER_BORROWED_BOOK_PAGE;

public class DeleteBorrowedBookSubmitCommand extends CommandWrapper {
    BookService bookService = BookServiceImpl.getInstance();

    @Override
    public String performExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = Integer.valueOf(request.getParameter(USER_ID));
        Integer bookId = Integer.valueOf(request.getParameter(BOOK_ID));
        bookService.deleteBorrowedBookByUserId(bookId,userId);
        System.out.println("AFTER DELETING BORROWED BOOK");
        List<BorrowedBook> borrowedBooks =new ArrayList<>();
        borrowedBooks= bookService.findAllBorrowedBooksByUserId(userId);
        System.out.println(borrowedBooks);
        request.setAttribute("userId",userId);
        request.setAttribute("borrowedBooks", borrowedBooks);
        request.getRequestDispatcher(USER_BORROWED_BOOK_PAGE).forward(request,response);
        return FORWARD;
    }


}

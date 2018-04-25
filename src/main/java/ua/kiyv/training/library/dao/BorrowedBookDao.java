package ua.kiyv.training.library.dao;

import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.model.BorrowedBook;

import java.util.List;

public interface BorrowedBookDao extends GenericDao<BorrowedBook> {
    public List<BorrowedBook> findAllByUserId(int id);
    public void createBorrowedBookByUserId(Book book, int userId);
}

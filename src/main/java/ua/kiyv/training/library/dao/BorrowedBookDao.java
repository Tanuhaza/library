package ua.kiyv.training.library.dao;

import ua.kiyv.training.library.model.BorrowedBook;

import java.util.List;

/**
 * DAO for BorrowedBook entity
 */

public interface BorrowedBookDao extends GenericDao<BorrowedBook> {

    /**
     * find all borrowed books by user id
     *
     * @param id
     * @return
     */
    List<BorrowedBook> findAllByUserId(Integer id);

    /**
     * create borrowed book matching user id and
     * book id in db
     *
     * @param bookId
     * @param userId
     */
    void createBorrowedBookByUserId(Integer bookId, Integer userId);

    /**
     * delete match book-user in db table
     *
     * @param bookId
     * @param userId
     */
    void deleteBorrowedBookByUserId(Integer bookId, Integer userId);

    /**
     * check if book is on loan by user
     *
     * @param bookId
     * @param userId
     */
    Boolean isBookOnLoanByUser(Integer bookId, Integer userId);

    /**
     * delete borrowed book by book id
     *
     * @param id
     */
    void deleteById(Integer id);
}

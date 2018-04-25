package ua.kiyv.training.library.dao.Impl.query;

public interface BorrowedBookQuery {
    String SELECT_ALL_BORROWED_BOOKS = "SELECT * FROM book_out_on_loan as bl left join book as b on bl.book_id=b.id" +
            " left join book_author as ba on b.id=ba.book_id " +
            "left join author as a on ba.author_id=a.id";
    String FILTER_BY_USER_ID = " where bl.user_id= ?";

    String CREATE_BORROWED_BOOK = "INSERT INTO book_out_on_loan (user_id, book_id,startDate, returnDate ) VALUES (?, ?, ?, ?)";
    String DELETE_BORROWED_BOOK = "DELETE FROM book WHERE id = ?";
}

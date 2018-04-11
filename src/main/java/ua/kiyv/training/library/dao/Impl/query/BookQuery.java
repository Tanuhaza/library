package ua.kiyv.training.library.dao.Impl.query;

import java.security.PublicKey;

public interface BookQuery {
    public static final String CREATE_BOOK = "INSERT INTO book (title,description,picture,available,quantity," +
            "year,genre_id,keywords,added_date,rate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String FIND_ALL_BOOKS = "SELECT * FROM book as b left join book_author as ba on b.id=ba.book_id " +
            "left join author as a on ba.author_id=a.id";
    public static final String FILTER_BY_ID = "where b.id=?";

    String UPDATE_BOOK = "UPDATE question SET question = ?, topic_id = ? WHERE id = ?";
    String DELETE_BOOK = "DELETE FROM author WHERE id = ?";

}

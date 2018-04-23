package ua.kiyv.training.library.dao.Impl.query;

import java.security.PublicKey;

public interface BookQuery {
    String CREATE_BOOK = "INSERT INTO book (title,description,picture,available,quantity," +
            "year,genre_id,keywords) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    String SELECT_ALL_BOOKS = "SELECT * FROM book as b left join book_author as ba on b.id=ba.book_id " +
            "left join author as a on ba.author_id=a.id";
    String FILTER_BY_ID = "  where b.id= ?";
    String FILTER_BY_TITLE = "  where b.title= ?";

    String UPDATE_BOOK = "UPDATE book SET title = ?, description = ?, picture=?,available=?,quantity=?,year=?,genre_id=?," +
            "keywords=?,rate=?  WHERE id = ?";
    String DELETE_BOOK = "DELETE FROM book WHERE id = ?";
    String DELETE_MATCH_BOOK_AUTHOR = "DELETE FROM book_author WHERE book_id = ?";
    String MATCH_BOOK_AUTHOR ="INSERT INTO book_author (book_id,author_id) values (?,?)";

}

package ua.kiyv.training.library.dao.Impl.query;

import java.security.PublicKey;

public interface BookQuery {
    String CREATE_BOOK = "INSERT INTO book (title,description,picture,available,quantity," +
            "year,genre_id,keywords) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    String SELECT_ALL_BOOKS = "SELECT * FROM book as b left join book_author as ba on b.id=ba.book_id " +
            "left join author as a on ba.author_id=a.author_id";
    String FILTER_BY_ID = "  where b.id= ?";
    String FILTER_BY_TITLE = "  where b.title= ?";
    String FILTER_BY_GENRE_ID = "  where b.genre_id= ?";

    String UPDATE_BOOK = "UPDATE book SET title = ?, description = ?, picture=?,available=?,quantity=?,year=?,genre_id=?," +
            "keywords=?,rate=?  WHERE id = ?";
    String DELETE_BOOK = "DELETE FROM book WHERE id = ?";
    String DELETE_MATCH_BOOK_AUTHOR = "DELETE FROM book_author WHERE book_id = ?";
    String MATCH_BOOK_AUTHOR ="INSERT INTO book_author (book_id,author_id) values (?,?)";
    String SEARCH_BY_AUTHOR =" WHERE a.unique_cipher LIKE ?";
    String SEARCH_BY_TITLE =" WHERE b.title LIKE ?";
    String SEARCH_BY_KEYWORDS =" WHERE b.keywords LIKE ?";
    String SEARCH_BY_ALL=" WHERE a.unique_cipher or b.title or b.keywords LIKE ?";


}

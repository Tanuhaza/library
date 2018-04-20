package ua.kiyv.training.library.dao.Impl.mapper;

import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.model.BorrowedBook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class BookMapper implements ObjectMapper<Book> {

    @Override
    public Book extractFromResultSet(ResultSet rs) throws SQLException {

        return new Book.Builder()
                .setId(rs.getInt("id"))
                .setTitle( rs.getString("title") )
                .setDiscription( rs.getString("description") )
                .setPictureId( rs.getString("picture") )
                .setAvaliable( rs.getBoolean("available") )
                .setQuantity( rs.getInt("quantity") )
                .setYear( rs.getInt("year") )
                .setGenreId( rs.getInt("genre_id") )
                .setKeywords( rs.getString("keywords") )
                .setAddedDate( rs.getDate("added_date") )
                .setRate( rs.getInt("rate") )
                .build();
    }

    @Override
    public Book makeUnique(Map<Integer, Book> cache,
                             Book book) {
        cache.putIfAbsent(book.getId(),book);
        return cache.get(book.getId());
    }
}

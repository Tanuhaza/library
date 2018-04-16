package ua.kiyv.training.library.dao.Impl.mapper;

import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.model.BorrowedBook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class BorrowedBookMapper implements ObjectMapper<BorrowedBook> {

    @Override
    public BorrowedBook extractFromResultSet(ResultSet rs) throws SQLException {
        BookMapper bookMapper = new BookMapper();
        Book book = bookMapper.extractFromResultSet(rs);
        return new BorrowedBook.Builder()
                .setId(rs.getInt("id"))
                .setTitle( rs.getString("title") )
                .setDiscription( rs.getString("description") )
                .setPictureId( rs.getString("picture") )
                .setAvaliable( rs.getBoolean("avaliable") )
                .setQuantity( rs.getInt("quantity") )
                .setYear( rs.getInt("year") )
                .setGenreId( rs.getInt("genre_id") )
                .setKeywords( rs.getString("keywords") )
                .setAddedDate( rs.getDate("added_date") )
                .setRate( rs.getInt("rate") )
                .setStartDate(rs.getDate("startDate"))
                .setDueToReturnDate(rs.getDate("returnDate"))
                .build();
    }

    @Override
    public BorrowedBook makeUnique(Map<Integer, BorrowedBook> cache,
                           BorrowedBook borrowedBook) {
        cache.putIfAbsent(borrowedBook.getId(), borrowedBook);
        return cache.get(borrowedBook.getId());
    }
}

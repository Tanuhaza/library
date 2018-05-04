package ua.kiyv.training.library.dao.Impl.mapper;

import ua.kiyv.training.library.model.Book;
import ua.kiyv.training.library.model.BorrowedBook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class BorrowedBookMapper implements ObjectMapper<BorrowedBook> {

    @Override
    public BorrowedBook extractFromResultSet(ResultSet rs) throws SQLException {
//        try {
//            BorrowedBook.Builder builder = new BorrowedBook.Builder();
//            builder.setId(rs.getInt("book_id"));
//            System.out.println("1");
//            builder.setTitle(rs.getString("title"));
//            System.out.println("2");
//            builder.setDiscription(rs.getString("description"));
//            System.out.println("3");
//            builder.setPictureId(rs.getString("picture"));
//            System.out.println("4");
//            builder.setAvaliable(rs.getBoolean("available"));
//            System.out.println("5");
//            builder.setQuantity(rs.getInt("quantity"));
//            System.out.println("6");
//            builder.setYear(rs.getInt("year"));
//            System.out.println("7");
//            builder.setGenreId(rs.getInt("genre_id"));
//            System.out.println("8");
//            builder.setKeywords(rs.getString("keywords"));
//            System.out.println("9");
//            builder.setAddedDate(rs.getDate("added_date"));
//            System.out.println("10");
//            builder.setRate(rs.getInt("rate"));
//            System.out.println("11");
//            builder.setStartDate(rs.getDate("startDate"));
//            System.out.println("12");
//            builder.setDueToReturnDate(rs.getDate("returnDate"));
//            System.out.println("13");
//            return builder.build();
//        BorrowedBook.Builder bBuilder = BorrowedBook.builder();
//        Book.Builder builder = Book.builder();
            return new BorrowedBook.Builder()
                    .setId(rs.getInt("id"))
                    .setTitle(rs.getString("title"))
                    .setDiscription(rs.getString("description"))
                    .setPictureId(rs.getString("picture"))
                    .setAvaliable(rs.getBoolean("available"))
                    .setQuantity(rs.getInt("quantity"))
                    .setYear(rs.getInt("year"))
                    .setGenreId(rs.getInt("genre_id"))
                    .setKeywords(rs.getString("keywords"))
                    .setAddedDate(rs.getDate("added_date"))
                    .setRate(rs.getInt("rate"))
                    .setStartDate(rs.getDate("startDate"))
                    .setDueToReturnDate(rs.getDate("returnDate"))
                    .build();

//        } catch (SQLException e) {
//            System.out.println("BorrowedBookMapper");
//        }
//        return null;
    }

    @Override
    public BorrowedBook makeUnique(Map<Integer, BorrowedBook> cache,
                                   BorrowedBook borrowedBook) {
        cache.putIfAbsent(borrowedBook.getId(), borrowedBook);
        return cache.get(borrowedBook.getId());
    }
}

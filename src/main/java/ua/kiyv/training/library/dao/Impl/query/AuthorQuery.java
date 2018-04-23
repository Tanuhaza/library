package ua.kiyv.training.library.dao.Impl.query;

public interface AuthorQuery {
    String CREATE_AUTHOR = "INSERT INTO author (firstName,lastName, unique_cipher) VALUES (?, ?,?)";
    String SELECT_ALL_AUTHORS = "SELECT * FROM author";
    String FILTER_BY_ID = " WHERE id = ?";
    String FILTER_BY_FIRST_LAST_NAME = " WHERE firstName = ? and lastName=?";
    String UPDATE_AUTHOR = "UPDATE author SET firstName = ?, lastName = ? WHERE id = ?";
    String DELETE_AUTHOR = "DELETE FROM author WHERE id = ?";
}

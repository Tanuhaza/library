package ua.kiyv.training.library.dao.Impl.query;

public interface UserQuery {
    String CREATE_USER = "INSERT INTO user (firstName,lastName,email,phone,password,role) VALUES (?, ?, ?, ?, ?, ?)";
    String SELECT_ALL_USERS = "SELECT * FROM library.user as u left join book_out_on_loan as bl on " +
            "u.id=bl.user_id left join book as b on b.id=bl.book_id ";
    String FILTER_BY_ID = " WHERE u.id = ?";
    String UPDATE_USER = "UPDATE user SET firstName = ?, lastName = ?, email=?, phone=?, password=?,role=? WHERE id = ?";
    String DELETE_USER = "DELETE FROM author WHERE id = ?";
    String FIND_USER_BY_EMAIL = "SELECT * FROM library.user where email=? ";
}

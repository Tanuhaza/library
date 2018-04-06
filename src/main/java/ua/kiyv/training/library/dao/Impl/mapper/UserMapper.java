package ua.kiyv.training.library.dao.Impl.mapper;

import ua.kiyv.training.library.model.Role;
import ua.kiyv.training.library.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements ObjectMapper<User> {


    @Override
    public User extractFromResultSet(ResultSet rs) throws SQLException {
        return new User.Builder()
                .setId(rs.getInt("id") )
                .setFirstName( rs.getString("firstName") )
                .setLastName( rs.getString("lastName") )
                .setLogin(rs.getString("login"))
                .setPassword(rs.getString("password"))
                .setEmail(rs.getString("email"))
                .setRole(Role.valueOf(rs.getString("role")))
                .build();
    }
}


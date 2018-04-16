package ua.kiyv.training.library.dao.Impl.mapper;

import ua.kiyv.training.library.model.Role;
import ua.kiyv.training.library.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserMapper implements ObjectMapper<User> {


    @Override
    public User extractFromResultSet(ResultSet rs) throws SQLException {
        return new User.Builder()
                .setId(rs.getInt("id") )
                .setFirstName( rs.getString("firstName") )
                .setLastName( rs.getString("lastName") )
                .setEmail(rs.getString("email"))
                .setPhone(rs.getString("phone"))
                .setPassword(rs.getString("password"))
                .setRole(Role.valueOf(rs.getString("role")))
                .build();
    }

    @Override
    public User makeUnique(Map<Integer, User> cache,
                              User user) {
        cache.putIfAbsent(user.getId(),user);
        return cache.get(user.getId());
    }
}


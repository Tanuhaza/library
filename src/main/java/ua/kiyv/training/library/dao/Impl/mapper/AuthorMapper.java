package ua.kiyv.training.library.dao.Impl.mapper;

import ua.kiyv.training.library.model.Author;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class AuthorMapper implements ObjectMapper<Author> {
    @Override
    public Author extractFromResultSet(ResultSet rs) throws SQLException {
        return new Author.Builder()
                .setId(rs.getInt("id"))
                .setFirstName( rs.getString("firstName") )
                .setLastName( rs.getString("lastName") )
                .build();
    }

    @Override
    public Author makeUnique(Map<Integer, Author> cache,
                           Author author) {
        cache.putIfAbsent(author.getId(),author);
        return cache.get(author.getId());
    }

}

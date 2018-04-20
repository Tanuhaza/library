package ua.kiyv.training.library.dao.Impl.mapper;

import ua.kiyv.training.library.model.Author;
import ua.kiyv.training.library.model.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class GenreMapper implements ObjectMapper<Genre> {
    @Override
    public Genre extractFromResultSet(ResultSet rs) throws SQLException {
        return new Genre.Builder()
                .setId(rs.getInt("id"))
                .setName( rs.getString("name") )
                .build();
    }

    @Override
    public Genre makeUnique(Map<Integer, Genre> cache,
                           Genre genre) {
        cache.putIfAbsent(genre.getId(),genre);
        return cache.get(genre.getId());
    }

}

package ua.kiyv.training.library.dao.Impl;

import org.apache.log4j.Logger;
import ua.kiyv.training.library.exception.DaoException;
import ua.kiyv.training.library.dao.GenreDao;
import ua.kiyv.training.library.dao.Impl.mapper.GenreMapper;
import ua.kiyv.training.library.dao.connection.DaoConnection;
import ua.kiyv.training.library.dao.connection.Jdbc.JdbcTransactionHelper;
import ua.kiyv.training.library.model.Genre;
import ua.kiyv.training.library.utils.constants.LoggerMessages;
import ua.kiyv.training.library.utils.constants.MessageKeys;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static ua.kiyv.training.library.dao.Impl.query.GenreQuery.SELECT_ALL_GENRES;

/**
 * * Implementation of genre dao, which works with MySql using jdbc
 */
public class JdbcGenreDao implements GenreDao {

    private static final Logger logger = Logger.getLogger(JdbcGenreDao.class);

    @Override
    public void create(Genre entity) {
    }

    @Override
    public Genre findById(Integer id) {
        return null;
    }

    @Override
    public List<Genre> findAll() {
        Genre genre;
        List<Genre> genres = new ArrayList<>();
        try (DaoConnection connection = JdbcTransactionHelper.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_GENRES)) {
            GenreMapper genreMapper = new GenreMapper();
            while (resultSet.next()) {
                genre = genreMapper.extractFromResultSet(resultSet);
                genres.add(genre);
            }
        } catch (SQLException ex) {
            logger.error(LoggerMessages.ERROR_FIND_ALL_GENRES);
            throw new DaoException(ex, MessageKeys.WRONG_AUTHOR_DB_CAN_NOT_GET_ALL_GENRES);
        }
        return genres;
    }

    @Override
    public void update(Genre entity) {
    }

    @Override
    public void delete(Genre entity) {
    }
}

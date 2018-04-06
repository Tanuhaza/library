package ua.kiyv.training.library.dao.Impl;


import ua.kiyv.training.library.dao.*;

public class JdbcDaoFactory extends DaoFactory {

    @Override
    public UserDao createUserDao() {
        return new JdbcUserDao();
    }

    @Override
    public AuthorDao createAuthorDao() {
        return new JdbcAuthorDao();
    }

    @Override
    public BookDao createBookDao() {
        return new JdbcBookDao();
    }

    @Override
    public BorrowedBookDao createBorrowedBookDao() {
        return new JdbcBorrowedBookDao();
    }

    @Override
    public GenreDao createGenreDao() {
        return new JdbcGenreDao();
    }
}

package ua.kiyv.training.library.dao;

import ua.kiyv.training.library.dao.Impl.JdbcDaoFactory;

/**
 * dao factory which generate other dao
 */
public abstract class DaoFactory {

    private static DaoFactory daoFactory;

    public abstract AuthorDao createAuthorDao();

    public abstract UserDao createUserDao();

    public abstract BookDao createBookDao();

    public abstract BorrowedBookDao createBorrowedBookDao();

    public abstract GenreDao createGenreDao();

    public static DaoFactory getInstance() {

        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    DaoFactory temp = new JdbcDaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}


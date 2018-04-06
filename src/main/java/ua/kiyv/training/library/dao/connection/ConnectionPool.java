package ua.kiyv.training.library.dao.connection;


public interface ConnectionPool {

    DaoConnection getConnection();
}

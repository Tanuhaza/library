package ua.kiyv.training.library.dao;

import java.util.List;

public interface GenericDao<T> {
    void create (T entity);
    T findById(int id);
    List<T> findAll();
    void update(T entity);
    void delete(T entity);
}

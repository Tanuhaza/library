package ua.kiyv.training.library.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {
    void create (T entity);
    T findById(Integer id);
    List<T> findAll();
    void update(T entity);
    void delete(T entity);
}

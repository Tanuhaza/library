package ua.kiyv.training.library.dao;

import java.util.List;
import java.util.Optional;

/**
 * interface which defines basic dao actions
 *
 * @param <T>
 */
public interface GenericDao<T> {

    /**
     * create specified entity in db
     *
     * @param entity entity which will be created
     */
    void create(T entity);

    /**
     * this method search entity instance by specified id
     *
     * @param id entity's id
     * @return Entity with specified id in Optional wrapper
     */
    T findById(Integer id);

    /**
     * this methods finds all instancess in db
     *
     * @return list with all instances
     */
    List<T> findAll();

    /**
     * updates specified entity in db
     *
     * @param entity entity which will be updated
     */
    void update(T entity);

    /**
     * delete instance in db
     *
     * @param entity which will be deleted
     */
    void delete(T entity);
}

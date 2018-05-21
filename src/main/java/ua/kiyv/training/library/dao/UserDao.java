package ua.kiyv.training.library.dao;

import ua.kiyv.training.library.model.User;

import java.util.List;

/**
 * DAO for User entity
 */
public interface UserDao extends GenericDao<User> {

    /**
     * find one user by cellphone which is unique
     *
     * @param email email of the user
     * @return
     */
    User findUserByEmail(String email);

    /**
     * this method are used for pagination.
     * It finds some quantity of users which starts
     * from specific user's id
     *
     * @param startFrom
     * @param quantity
     * @return
     */
    List<User> getAllWithLimitPerPage(Integer startFrom, Integer quantity);

    /**
     * count all users
     *
     * @param
     * @return
     */
    int countAllUsers();
}

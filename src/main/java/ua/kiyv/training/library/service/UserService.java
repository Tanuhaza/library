package ua.kiyv.training.library.service;

import ua.kiyv.training.library.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    /**
     * @param user entity of user to be created and saved in data base
     */
    void create(User user);
    /**
     * @param id user's id, whose entity will be returned
     * @return user entity with specified id
     */
    Optional<User> findById(Integer id);

    /**
     * @return list of user entity
     */
    List<User> findAll();

    /**
     * @param user entity of user to be updated and saved in data base
     */
    void update(User user);

    /**
     * @param user entity of user to be deleted from data base
     */
    void delete(User user);

    /**
     * @param login    user's login, whose entity will be returned
     * @param password user's password, whose entity will be returned
     * @return user entity with specified email (login)
     */
    public Optional<User> getUserByEmailPassword(String login, String password);

    public int countAllUsers();

    public List<User> getAllWithLimitPerPage(Integer startFrom, Integer quantity);

    public String encrypt(String password);
}

package ua.kiyv.training.library.dao;

import ua.kiyv.training.library.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends GenericDao<User> {
    public User findUserByEmail(String email);
    public List<User> getAllWithLimitPerPage(Integer startFrom, Integer quantity);
    public int countAllUsers();
}

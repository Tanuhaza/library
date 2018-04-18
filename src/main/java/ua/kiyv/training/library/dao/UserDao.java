package ua.kiyv.training.library.dao;

import ua.kiyv.training.library.model.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User> {
    public Optional<User> findUserByEmail(String email);
}

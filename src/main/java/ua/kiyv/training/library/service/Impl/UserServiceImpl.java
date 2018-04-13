package ua.kiyv.training.library.service.Impl;

import ua.kiyv.training.library.model.User;
import ua.kiyv.training.library.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{
    @Override
    public void create(User user) {

    }

    @Override
    public Optional<User> findById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public Optional<User> getUserByLoginPassword(String login, String password) {
        return null;
    }
}

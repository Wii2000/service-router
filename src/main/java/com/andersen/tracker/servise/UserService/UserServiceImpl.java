package com.andersen.tracker.servise.UserService;

import com.andersen.tracker.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public User get(long id) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean save(User user) {
        return true;
    }
}

package com.andersen.tracker.servise.UserService;


import com.andersen.tracker.dao.UserDao;
import com.andersen.tracker.model.User;

import java.util.List;

/**
 * Имплементация сервиса использующая ДАО с внутренней памятью
 */
public class UserServiceInMemoryImpl implements UserService {
    public static UserDao userDao;

    public UserServiceInMemoryImpl() {
        userDao = new UserDao();
    }

    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User get(long id) {
        return userDao.get(id);
    }

    @Override
    public boolean delete(long id) {
        return userDao.delete(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}

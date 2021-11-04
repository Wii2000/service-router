package com.andersen.tracker.servise.UserService;

import com.andersen.tracker.model.User;

import java.util.List;

/**
 * Интерфейс сервиса определяющий основные операции над пользователями
 */
public interface UserService {
    //get user by id(chatId)
    User get(long id);
    //true if user was succcessufully removed
    boolean delete(long id);
    //get all users
    List<User> getAll();
    //save or update user, return result
    User save(User user);
}

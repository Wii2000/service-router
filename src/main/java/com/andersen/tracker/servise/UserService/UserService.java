package com.andersen.tracker.servise.UserService;

import com.andersen.tracker.model.User;

import java.util.List;

/**
 * Интерфейс сервиса определяющий основные операции над пользователями
 */
public interface UserService {
    //получить по айди
    User get(long id);
    //удалить оп айди при успехе возвращать true
    boolean delete(long id);
    //получить всех юзеров
    List<User> getAll();
    //сохранить или изменить, отправляет true при успехе
    boolean save(User user);
}

package com.andersen.tracker.dao;

import com.andersen.tracker.model.Role;
import com.andersen.tracker.model.User;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * ДАО взаимодействующий с БД исполненной в HashMap
 */
public class UserDao {
    private static final Logger log = getLogger(UserDao.class);
    private static Map<Long, User> map = new HashMap();

    public UserDao() {
        map = new HashMap();
        map.put((long) 727239620, new User(727239620, "Dmitriy", "Davydov", Role.ADMIN));
        map.put((long) 1, new User(1, "Dmitriy1", "Davydov1", Role.USER));
        map.put((long) 2, new User(2, "Dmitriy2", "Davydov2", Role.USER));
        map.put((long) 3, new User(3, "Dmitriy3", "Davydov3", Role.USER));
    }

    public User save(User user) {
        map.put(user.getChatId(), user);
        return user;
    }

    public List<User> getAll() {
        return new ArrayList<>(map.values());
    }

    public User get(long chatId) {
        return map.get(chatId);
    }

    public boolean delete(long chatId) {
        return map.remove(chatId) != null;
    }
}

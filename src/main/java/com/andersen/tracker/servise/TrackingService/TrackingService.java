package com.andersen.tracker.servise.TrackingService;

import com.andersen.tracker.model.Tracking;

import java.util.List;


public interface TrackingService {
    //получить все трекинги для одного юзера
    List<Tracking> getAllForUser();

    //получить трекинги для всех юзеров за день
    List<Tracking> getForTheDay();

    //получить последний трекинг для юзера
    Tracking getLastForUser(long id);

    //сохранить или обновить(если уже присутствует в БД) трекинг
    Tracking save(Tracking tracking);
}

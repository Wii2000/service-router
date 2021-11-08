package com.andersen.tracker.model;

import java.time.LocalDate;

public class Tracking {
    //айди трекинга присевается в БД сервис-бухгалтера
    private Integer id;
    //айди юзера
    private long userId;
    //описание задачи
    private String task;
    //дата трекинга
    private LocalDate date;
    //сколько часов затрачено
    private int hoursSpent;

    public Tracking(long userId, String task, LocalDate date, int hoursSpent) {
        this(null, userId, task, date, hoursSpent);
    }

    public Tracking(Integer id, long userId, String task, LocalDate date, int hoursSpent) {
        this.id = id;
        this.userId = userId;
        this.task = task;
        this.date = date;
        this.hoursSpent = hoursSpent;
    }

    public Integer getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHoursSpent() {
        return hoursSpent;
    }

    public long getUserId() {
        return userId;
    }
}

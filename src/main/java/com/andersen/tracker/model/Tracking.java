package com.andersen.tracker.model;

import java.time.LocalDate;

public class Tracking {
    private Integer id;
    private User user;
    private String task;
    private LocalDate date;
    private int hoursSpent;

    public Tracking(User user, String task, LocalDate date, int hoursSpent) {
        this(null, user, task, date, hoursSpent);
    }

    public Tracking(Integer id, User user, String task, LocalDate date, int hoursSpent) {
        this.id = id;
        this.user = user;
        this.task = task;
        this.date = date;
        this.hoursSpent = hoursSpent;
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
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
}

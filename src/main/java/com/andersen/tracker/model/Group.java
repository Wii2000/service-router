package com.andersen.tracker.model;

import java.util.List;

public class Group {
    private Integer id;
    private String name;
    private User teamLead;
    private List<User> users;

    public Group(String name) {
        this(null, name, null, null);
    }

    public Group(Integer id, String name, User teamLead, List<User> users) {
        this.id = id;
        this.name = name;
        this.teamLead = teamLead;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getTeamLead() {
        return teamLead;
    }

    public List<User> getUsers() {
        return users;
    }
}

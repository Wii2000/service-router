package com.andersen.tracker.model;

public class User {
    private final long chatId;
    private final String firstName;
    private final String lastName;
    private Role role;

    public User(long id, String firstName, String lastName) {
        this(id, firstName, lastName, Role.USER);
    }

    public User(long id, String name, String surname, Role role) {
        this.chatId = id;
        this.firstName = name;
        this.lastName = surname;
        this.role = role;
    }

    public long getChatId() {
        return chatId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Role getRole() {
        return role;
    }
}

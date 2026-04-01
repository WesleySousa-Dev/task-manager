package com.github.wesleysousa_dev.taskmanager.repository;

import com.github.wesleysousa_dev.taskmanager.model.User;
import com.github.wesleysousa_dev.taskmanager.util.JsonManipulator;

import java.util.List;
import java.util.Optional;

public class UserRepository {
    private JsonManipulator jsonManipulator;
    private List<User> users;

    public UserRepository(JsonManipulator json) {
        this.jsonManipulator = json;
        this.users = jsonManipulator.userList();
    }

    public List<User> getUsers() {
        return users;
    }

    public Optional<User> findByName(String name) {
        return users.stream().filter(u -> u.getName().equals(name)).findFirst();
    }

    public void addUser(User user) {
        users.add(user);
        jsonManipulator.createJson(users);
    }
}

package com.github.wesleysousa_dev.taskmanager.repository;

import com.github.wesleysousa_dev.taskmanager.model.Task;
import com.github.wesleysousa_dev.taskmanager.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public Optional<User> findByName(String name);
    public void addUser(User user);
}

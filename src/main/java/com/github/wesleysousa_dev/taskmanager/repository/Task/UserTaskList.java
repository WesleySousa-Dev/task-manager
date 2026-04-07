package com.github.wesleysousa_dev.taskmanager.repository.Task;

import com.github.wesleysousa_dev.taskmanager.model.Task;
import com.github.wesleysousa_dev.taskmanager.model.User;
import com.github.wesleysousa_dev.taskmanager.repository.User.UserRepository;

import java.util.List;

public class UserTaskList implements TaskRepository{
    private UserRepository userRepository;
    private User currentUser;
    private List<Task> userTaskList;

    public UserTaskList(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Task> taskList(User currentUser) {
        return userRepository.findByName(currentUser.getName()).get().getTaskList();
    }
}


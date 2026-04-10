package com.github.wesleysousa_dev.taskmanager.repository.Task;

import com.github.wesleysousa_dev.taskmanager.model.Priority;
import com.github.wesleysousa_dev.taskmanager.model.Task;
import com.github.wesleysousa_dev.taskmanager.model.User;
import com.github.wesleysousa_dev.taskmanager.repository.User.UserRepository;

import java.net.http.HttpClient;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserTaskRepository implements TaskRepository{
    private UserRepository userRepository;
    public UserTaskRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Task> taskList(User currentUser) {
        return userRepository.findByName(currentUser.getName()).get().getTaskList();
    }

    public List<Task> findByPriority(User currentUser, Priority priority) {
        Optional<User> useOpt = userRepository.findByName(currentUser.getName());
        return useOpt.get().getTaskList().stream().filter(task -> priority.equals(task.getPriority())).collect(Collectors.toList());
    }

    @Override
    public void addTask(User currentUser, Task task) {
        userRepository.findByName(currentUser.getName()).ifPresent( user -> {user.getTaskList().add(task);});
        userRepository.addAll();
    }
}


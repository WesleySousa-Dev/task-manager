package com.github.wesleysousa_dev.taskmanager.repository.Task;

import com.github.wesleysousa_dev.taskmanager.model.Task;
import com.github.wesleysousa_dev.taskmanager.model.User;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    public List<Task> taskList(User currentUser);
    public void addTask(User currentUser, Task task);
}

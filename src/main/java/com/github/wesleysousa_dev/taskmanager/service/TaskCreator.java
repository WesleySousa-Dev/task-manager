package com.github.wesleysousa_dev.taskmanager.service;

import com.github.wesleysousa_dev.taskmanager.model.Priority;
import com.github.wesleysousa_dev.taskmanager.model.Task;
import com.github.wesleysousa_dev.taskmanager.model.User;
import com.github.wesleysousa_dev.taskmanager.repository.UserRepository;

public class TaskCreator {
    UserRepository userRepository;
    User currentUser;
    Task task = new Task();
    UserInterface userInterface = new UserInterface();

    public TaskCreator() {}

    public TaskCreator(UserRepository userRepository, User currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    public void createTask(){
        setTaskData();
        currentUser.addTaskList(task);
        userRepository.addUser(currentUser);
    }

    private void setTaskData() {
        task.setName(userInterface.askStr());
        task.setDescription(userInterface.askStr());
        task.setPriority(Priority.BAIXA);
        task.setStatus(false);
    }


}


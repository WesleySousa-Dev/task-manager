package com.github.wesleysousa_dev.taskmanager;

import com.github.wesleysousa_dev.taskmanager.repository.Task.TaskRepository;
import com.github.wesleysousa_dev.taskmanager.repository.Task.UserTaskRepository;
import com.github.wesleysousa_dev.taskmanager.repository.User.UserJsonRepository;
import com.github.wesleysousa_dev.taskmanager.repository.User.UserRepository;
import com.github.wesleysousa_dev.taskmanager.service.*;
import com.github.wesleysousa_dev.taskmanager.util.JsonManipulator;

public class Main {
    static void main() {
        JsonManipulator json = new JsonManipulator();
        UserRepository userRepository = new UserJsonRepository(json);
        TaskRepository taskRepository = new UserTaskRepository(userRepository);

        UserIO userInterface = new UserIO();
        UserLogin userLogin = new UserLogin(userRepository, userInterface);
        UserRegister userRegister = new UserRegister(userRepository);

        TaskCreator taskCreator = new TaskCreator(taskRepository, userInterface);

        UserInterface menu = new UserInterface(userInterface, userLogin, taskRepository ,userRegister, taskCreator);

        menu.startMenu();

    }
}

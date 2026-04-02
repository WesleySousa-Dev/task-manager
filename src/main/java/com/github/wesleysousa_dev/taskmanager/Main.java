package com.github.wesleysousa_dev.taskmanager;

import com.github.wesleysousa_dev.taskmanager.repository.UserRepository;
import com.github.wesleysousa_dev.taskmanager.service.*;
import com.github.wesleysousa_dev.taskmanager.util.JsonManipulator;

public class Main {
    static void main() {
        JsonManipulator json = new JsonManipulator();
        UserRepository userRepository = new UserRepository(json);

        UserIO userInterface = new UserIO();
        UserLogin userLogin = new UserLogin(userRepository, userInterface);
        UserRegister userRegister = new UserRegister(userRepository);
        TaskCreator taskCreator = new TaskCreator(userRepository, userInterface);

        UserInterface menu = new UserInterface(userInterface, userLogin, userRegister, taskCreator);

        menu.startMenu();

    }
}

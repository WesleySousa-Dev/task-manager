package com.github.wesleysousa_dev.taskmanager.service;

import com.github.wesleysousa_dev.taskmanager.model.User;
import com.github.wesleysousa_dev.taskmanager.repository.UserRepository;

public class UserRegister {
    UserRepository userRepository;
    UserInterface userInterface = new UserInterface();
    User user = new User();

    public UserRegister(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void userRegister() {
        user.setName(userInterface.askStr());
        userRepository.addUser(user);
    }

}

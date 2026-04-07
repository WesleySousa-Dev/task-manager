package com.github.wesleysousa_dev.taskmanager.service;

import com.github.wesleysousa_dev.taskmanager.model.User;
import com.github.wesleysousa_dev.taskmanager.repository.UserJsonRepository;
import com.github.wesleysousa_dev.taskmanager.repository.UserRepository;

public class UserRegister {
    private UserRepository userRepository;
    private UserIO userInterface = new UserIO();
    private User user = new User();

    public UserRegister(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register() {
        userInterface.showMessage("Digite o seu nome para registrar: ");
        user.setName(userInterface.askStr());
        userRepository.addUser(user);
        userInterface.showMessage("Usuario" + " [" + user.getName() + "] " + "registrado");
    }

}

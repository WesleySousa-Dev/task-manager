package com.github.wesleysousa_dev.taskmanager.service;

import com.github.wesleysousa_dev.taskmanager.model.User;
import com.github.wesleysousa_dev.taskmanager.repository.UserJsonRepository;
import com.github.wesleysousa_dev.taskmanager.repository.UserRepository;

import java.util.Optional;


public class UserLogin {
    private UserRepository userRepository;
    private UserIO userInterface;
    private User currentUser;

    public UserLogin(UserRepository userRepository, UserIO userInterface) {
        this.userRepository = userRepository;
        this.userInterface = userInterface;
    }

    public boolean authenticate(){
        String userName = userInterface.askStr();

        Optional<User> findUser = userRepository.findByName(userName);

        if(findUser.isPresent()) {
            userInterface.showMessage("Usuario encontrado");
            currentUser = findUser.get();
            return true;
        } else {
            currentUser = null;
            userInterface.showMessage("Usuario não encontrado!");
            return false;
        }
    }

    public Optional<User> getCurrentUser() {
        return Optional.ofNullable(currentUser);
    }
}
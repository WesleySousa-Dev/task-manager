package com.github.wesleysousa_dev.taskmanager.service;

import com.github.wesleysousa_dev.taskmanager.model.User;
import com.github.wesleysousa_dev.taskmanager.repository.UserRepository;

import java.util.Optional;


public class UserLogin {
    private UserRepository userRepository;
    private User currentUser;

    public UserLogin() {}

    public UserLogin(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void authenticate(String name){
        Optional<User> findUser = userRepository.findByName(name);

        if(findUser.isPresent()) {
            System.out.println("Usuario encontrado");
            currentUser = findUser.get();
        } else {
            System.out.println("Usuario não encontrado!");
        }
    }

    public User getCurrentUser(){
        return currentUser;
    }
}
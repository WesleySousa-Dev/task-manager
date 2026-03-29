package org.example;

import org.example.model.User;
import org.example.util.JsonManipulator;

import java.util.List;
import java.util.Scanner;

public class UserRegister {
    public static User register(List<User> userList, String userName) {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        JsonManipulator jsonManipulator = new JsonManipulator();

        user.setName(userName);
        userList.add(user);

        jsonManipulator.createJson(userList);

        System.out.println("Usuario criado com sucesso");
        return user;
    }
}

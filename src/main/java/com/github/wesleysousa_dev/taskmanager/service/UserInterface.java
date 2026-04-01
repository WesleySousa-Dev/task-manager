package com.github.wesleysousa_dev.taskmanager.service;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);

    public String askStr(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public int askInt(String message) {
        System.out.println(message);
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }
}

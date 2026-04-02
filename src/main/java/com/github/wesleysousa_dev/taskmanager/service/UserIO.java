package com.github.wesleysousa_dev.taskmanager.service;

import java.util.Scanner;

public class UserIO {
    private Scanner scanner = new Scanner(System.in);

    public String askStr() {
        return scanner.nextLine();
    }

    public int askInt() {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

}

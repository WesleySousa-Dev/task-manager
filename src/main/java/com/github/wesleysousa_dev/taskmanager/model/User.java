package com.github.wesleysousa_dev.taskmanager.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Task> taskList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public void addTaskList(Task task) {
        taskList.add(task);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", taskList=" + taskList +
                '}';
    }
}

package com.github.wesleysousa_dev.taskmanager.service;

import com.github.wesleysousa_dev.taskmanager.model.Priority;
import com.github.wesleysousa_dev.taskmanager.model.Task;
import com.github.wesleysousa_dev.taskmanager.model.User;
import com.github.wesleysousa_dev.taskmanager.repository.Task.TaskRepository;
import com.github.wesleysousa_dev.taskmanager.repository.User.UserRepository;

public class TaskCreator {
    private UserIO userInterface;
    private UserRepository userRepository;
    private TaskRepository taskRepository;
    public TaskCreator(TaskRepository taskRepository, UserIO userInterface) {
       // this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.userInterface = userInterface;
    }

    public void createTask(User currentUser){
        Task task = new Task();

        setTaskData(task);
        taskRepository.addTask(currentUser, task);
        System.out.println("Tarefa criada com sucesso!");
    }

    private void setTaskData(Task task) {
        userInterface.showMessage("Digite o nome da sua tarefa: ");
        task.setName(userInterface.askStr());
        userInterface.showMessage("Digite a de4scrição da sua tarefa:");
        task.setDescription(userInterface.askStr());
        userInterface.showMessage("Qual a prioridade da sua tarefa");
        userInterface.showMessage("[BAIXA], [MEDIA] ou [ALTA]");
        task.setPriority(setTaskPriority(userInterface.askStr()));
        task.setStatus(false);
    }

    private Priority setTaskPriority(String priority){
        for(Priority p : Priority.values()){
            if(p.name().equalsIgnoreCase(priority.toUpperCase())) {
                return p;
            }
        }
        throw new RuntimeException("A opção " + '[' + priority + ']' + " não é uma opção valida");
    }


}


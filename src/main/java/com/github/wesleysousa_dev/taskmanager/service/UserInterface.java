package com.github.wesleysousa_dev.taskmanager.service;

import com.github.wesleysousa_dev.taskmanager.model.User;
import com.github.wesleysousa_dev.taskmanager.repository.Task.TaskRepository;

public class UserInterface {
    private UserIO userInterface;
    private UserLogin userLogin;
    private TaskRepository taskRepository;
    private UserRegister userRegister;
    private TaskCreator taskCreator;

    private User currentUser;

    public UserInterface(UserIO userInterface, UserLogin userLogin,TaskRepository taskRepository, UserRegister userRegister, TaskCreator taskCreator) {
        this.userInterface = userInterface;
        this.userLogin = userLogin;
        this.taskRepository = taskRepository;
        this.userRegister = userRegister;
        this.taskCreator = taskCreator;
    }

    public void startMenu(){

        userInterface.showMessage("Bem vindo usuario ao sistema de gerenciamento de tarefas");
        userInterface.showMessage("Selecione a opção desejada:");
        userInterface.showMessage("[1] para logar, [2] para registrar, [3] para sair ");

        int option = userInterface.askInt();

        switch (option) {
            case 1:
                userInterface.showMessage("Digite o seu nome de usuario: ");
                userLogin.authenticate();
                currentUser = userLogin.getCurrentUser().get();
                taskMenu(currentUser);
                break;
            case 2:
                userRegister.register(); break;
            case 3:
                userInterface.showMessage("Encerrando aplicação"); break;
            default:
                userInterface.showMessage("Opção invalida");
        }
    }
    private void taskMenu(User user){
        if(userLogin.getCurrentUser().isPresent()) {
            userInterface.showMessage(user.getName() +  " Selecione as seguinte opções: ");
            userInterface.showMessage("[1] para criar uma nova tarefa");

            int option = userInterface.askInt();
            switch (option) {
                case 1:
                    taskCreator.createTask(user); break;
                case 2: taskRepository.taskList(currentUser)
                        .forEach(t -> userInterface.showMessage(
                                "\nNome da tarefa: " + t.getName() +
                                "\nDescrição: " + t.getDescription() +
                                "\nPrioridade: " + t.getPriority()));
            }
        }
    }
}

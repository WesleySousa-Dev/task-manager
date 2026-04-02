package com.github.wesleysousa_dev.taskmanager.service;

public class UserInterface {
    private UserIO userInterface;
    private UserLogin userLogin;
    private UserRegister userRegister;
    private TaskCreator taskCreator;

    public UserInterface(UserIO userInterface, UserLogin userLogin, UserRegister userRegister, TaskCreator taskCreator) {
        this.userInterface = userInterface;
        this.userLogin = userLogin;
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
                userLogin.authenticate(); taskMenu(userLogin);break;
            case 2:
                userRegister.register(); break;
            case 3:
                userInterface.showMessage("Encerrando aplicação"); break;
            default:
                userInterface.showMessage("Opção invalida");
        }
    }

    private void taskMenu(UserLogin authentic){
        if(userLogin.authenticated()== true) {
            userInterface.showMessage(userLogin.getCurrentUser().get().getName() + " Selecione as seguinte opções: ");
            userInterface.showMessage("[1] para criar uma nova tarefa");

            int option = userInterface.askInt();
            switch (option) {
                case 1:
                    taskCreator.createTask(userLogin.getCurrentUser().get());
            }
        }
    }
}

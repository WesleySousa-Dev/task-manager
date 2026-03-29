package org.example;

import org.example.model.User;
import org.example.util.JsonManipulator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class UserLogin {
    Scanner scanner = new Scanner(System.in);

    JsonManipulator jsonManipulator = new JsonManipulator();
    TaskCreator taskCreator = new TaskCreator();
    User _user = new User();

    private List<User> userList = jsonManipulator.userList().stream()
            .collect(Collectors.toList());

    public void loginMenu() {
        System.out.println("Olá, digite seu nome de usuario: ");
        String _userName = scanner.nextLine();

        boolean findUser = userExist(userList, _userName);

        if(findUser) {
            System.out.println("Usuario encontrado");
            _user = userList.stream()
                    .filter(user -> _userName.equals(user.getName()))
                    .findFirst().get();
            userOption();
        }
        else {
            System.out.println("usuario não encontrado, deseja se registrar como um novo usuario?");
            System.out.println("Digite [1] para sim para registar com o nome digitado e [2] para não:");
            int optionSelectec = scanner.nextInt();
            scanner.nextLine();

            switch (optionSelectec) {
                case 1:
                    _user = UserRegister.register(userList, _userName);
                    userOption(); break;
                default:
                    System.out.println("Encerrando aplicação");
            }
        }
    }

    private boolean userExist(List<User> user, String userName) {
        if(user.stream().anyMatch(u -> userName.equals(u.getName()))) {
            return true;
        }
        return false;
    }

    private void userOption(){
        boolean run = true;
        do {
            System.out.println("Digite [1] para registrar uma nova tarefa");
            System.out.println("Digite [2] para listar suas tarefas");
            int optionSelected = scanner.nextInt();
            scanner.nextLine();

            switch (optionSelected) {
                case 1 :
                    do {
                        taskCreator.newTask(userList, _user);

                        System.out.println("Deseja adicionar uma nova tarefa?");
                        System.out.println("Digite [1] para sim e [2] para não");
                        int userOption = scanner.nextInt();
                        scanner.nextLine();

                        if(userOption == 1 ) {} else {run = false;};

                    } while (run); break;
                case 2:
                    _user.getTaskList().forEach(u -> {;
                        System.out.println("Nome da tarefa: " + u.getName());
                        System.out.println("Descrição: " + u.getDescription());
                        System.out.println("Prioridade: " + u.getPriority());
                        System.out.println();
                    }); break;
                default:
                    System.out.println("Opção selecionada invalida!");break;
            }
        } while (run);

    }
}

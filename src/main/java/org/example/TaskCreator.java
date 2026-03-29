package org.example;

import org.example.model.Priority;
import org.example.model.Task;
import org.example.model.User;
import org.example.util.JsonManipulator;

import java.util.List;
import java.util.Scanner;

public class TaskCreator {
    private Task task = new Task();
    private JsonManipulator jsonManipulator = new JsonManipulator();

    private Scanner scanner = new Scanner(System.in);


    public void newTask(List<User> userList, User user){
        setTaskData();
        setPriority();

        for(User u : userList) {
            if(u.getName().equals(user.getName())) {
                u.addTaskList(task);
            }
        }
        jsonManipulator.createJson(userList);
        System.out.println("Tarefa criada com sucesso!");
        System.out.println();
    }
    
    private void setTaskData() {
        System.out.print("Nome da tarefa: ");
        task.setName(scanner.nextLine());

        System.out.print("Descrição da tarefa: ");
        task.setDescription(scanner.nextLine());
    }

    private void setPriority() {
        System.out.println("Digite [1] para prioridade baixa, [2] para média e [3] para alta");
        int prioritySelected = scanner.nextInt();

        switch (prioritySelected) {
            case 1:
                task.setPriority(Priority.BAIXA); break;
            case 2:
                task.setPriority(Priority.MEDIA); break;
            case 3:
                task.setPriority(Priority.ALTA); break;
            default: System.out.println("Opção selecionada invalida!");
        }
    }
}


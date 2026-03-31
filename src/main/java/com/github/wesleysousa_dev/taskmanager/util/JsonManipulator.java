package com.github.wesleysousa_dev.taskmanager.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.wesleysousa_dev.taskmanager.model.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonManipulator {
    ObjectMapper mapper = new ObjectMapper();
    String jsonDir = "jsonfiles/json/userlist.json";

    // Converte um objeto em json
    public void createJson(List<User> user) {
        ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();
        try {
            writer.writeValue(new File(jsonDir), user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //retorna uma lista do tipo User a partir de um json
    public List<User> userList() {
        try {
           File file = new File(jsonDir);

           //se o arquivo existir ou estiver em branco retorna um array em branco
           if(!file.exists() || file.length() == 0) {
                return new ArrayList<>();
           }
           return mapper.readValue(file, new TypeReference<List<User>>() {
           });
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}

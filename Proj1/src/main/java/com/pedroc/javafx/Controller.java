package com.pedroc.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {

    private final String fileName = "tasks.txt";
    private final File file = new File(fileName);

    @FXML
    private TextField newTask;

    @FXML
    private ListView<String> taskList;

    public void exitProgram(ActionEvent actionEvent) {
        List<String> tasks = taskList.getItems();
        try {
            FileWriter writer = new FileWriter(file);
            for (String task : tasks) {
                writer.write(task + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        System.exit(0);
    }

    public void addNewTask(ActionEvent actionEvent) {
        String text = newTask.getText();
        if (text.isEmpty()) return;
        taskList.getItems().add(text);
        newTask.clear();
        newTask.requestFocus();
    }

    public void deleteTask(ActionEvent actionEvent) {
        //my way
        int index = taskList.getSelectionModel().getSelectedIndex();
        if (index == -1) return;
        taskList.getItems().remove(index);

        //course way
//        String selectedTask = taskList.getSelectionModel().getSelectedItem();
//        if (selectedTask != null) {
//            taskList.getItems().remove(selectedTask);
//        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String task = reader.nextLine();
                taskList.getItems().add(task);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
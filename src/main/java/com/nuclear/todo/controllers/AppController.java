package com.nuclear.todo.controllers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    public AnchorPane appPane;
    public ListView<String> todoList;
    public ListView<String> doneList;
    public TextField newTodoInput;
    public Button addTodo;
    private ObservableList<String> todoItems = FXCollections.observableArrayList();
    private ObservableList<String> doneItems = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        todoList.setItems(todoItems);
        doneList.setItems(doneItems);

        todoList.setCellFactory(CheckBoxListCell.forListView((Callback<String, ObservableValue<Boolean>>) item -> {
            BooleanProperty observable = new SimpleBooleanProperty();
            observable.addListener(
                    (obs, wasSelected, isNowSelected) -> {
                        ObservableList<String> array = todoList.getItems();
                        for (int i = 0; i < array.size(); i++) {
                            if (Objects.equals(item, array.get(i))) {
                                array.remove(item);
                                doneList.getItems().add(item);
                                break;
                            }
                        }
                    }
            );
            return observable;
        }));

        addTodo.setOnAction(event -> {
            todoList.getItems().add(newTodoInput.getText());
            newTodoInput.setText("");
        });
    }
}

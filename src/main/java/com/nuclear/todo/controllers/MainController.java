package com.nuclear.todo.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public MenuBar menuBar;
    public MenuItem close;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuBar.useSystemMenuBarProperty().set(true);
        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("That was easy, wasn't it?");
            }
        });
    }
}

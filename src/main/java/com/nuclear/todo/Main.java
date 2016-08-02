package com.nuclear.todo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hello World");
        initRootLayout(600, 400);
        initAppLayout();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void initRootLayout(int width, int height) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/root.fxml"));
        root = loader.load();
        Scene scene = new Scene(root, width, height);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initAppLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/app.fxml"));
        AnchorPane anchorPane = loader.load();
        root.setCenter(anchorPane);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}

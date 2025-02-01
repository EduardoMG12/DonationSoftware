package com.charleseduardo.donation.donationsjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private static Stage primaryStage;
    private static AnchorPane rootPane;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        rootPane = FXMLLoader.load(MainApp.class.getResource("login.fxml"));

        Scene scene = new Scene(rootPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Donation Program - Login");
        primaryStage.setResizable(true);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void changeScreen(String fxmlPath) throws IOException {
        AnchorPane newPane = FXMLLoader.load(MainApp.class.getResource(fxmlPath));
        rootPane.getChildren().setAll(newPane);
    }

    public static void main(String[] args) {
        launch(args);
    }
}


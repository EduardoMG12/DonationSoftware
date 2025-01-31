package com.charleseduardo.donation.donationsjavafx;

import com.charleseduardo.donation.donationsjavafx.controllers.RegisterController;
import com.charleseduardo.donation.donationsjavafx.dao.DatabaseConnection;
import com.charleseduardo.donation.donationsjavafx.dao.UserDAO;
import com.charleseduardo.donation.donationsjavafx.services.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import java.sql.Connection;


public class MainApp extends Application {

    public void start(Stage primaryStage) throws IOException {


        AnchorPane loader = FXMLLoader.load(MainApp.class.getResource("login.fxml"));

        Scene scene = new Scene(loader);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Donation Program - Register");
        primaryStage.setResizable(true);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

// Tela Home
//    @Override
//    public void start(Stage primaryStage) throws IOException {
//        AnchorPane loader = FXMLLoader.load(MainApp.class.getResource("home.fxml"));
//        Scene scene = new Scene(loader);
//
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Donation Program - Home");
//        primaryStage.setResizable(true);
//        primaryStage.setMaximized(true);
//        primaryStage.show();
//    }

    public static void main(String[] args) {
        launch(args);
    }
}

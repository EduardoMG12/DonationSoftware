package com.charleseduardo.donation.donationsjavafx.controllers;

import com.charleseduardo.donation.donationsjavafx.models.User;
import com.charleseduardo.donation.donationsjavafx.services.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class UserController {
    @FXML
    private TextField fullNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private ListView<User> userListView;

    private UserService userService;
    private ObservableList<User> userList;

    public UserController(UserService userService) {
        this.userService = userService;
        this.userList = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize() throws SQLException {
        loadUsers();
    }

    private void loadUsers() throws SQLException {
        userList.setAll(userService.getAllUsers());
        userListView.setItems(userList);
    }

    @FXML
    private void handleAddUser() throws SQLException {
        String fullName = fullNameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        User newUser = new User();
        newUser.setFullName(fullName);
        newUser.setEmail(email);
        newUser.setPassword(password);

        userService.addUser(newUser);
        loadUsers();
    }
}

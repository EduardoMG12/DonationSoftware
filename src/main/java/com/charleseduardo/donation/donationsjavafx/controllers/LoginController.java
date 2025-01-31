package com.charleseduardo.donation.donationsjavafx.controllers;

import com.charleseduardo.donation.donationsjavafx.dao.DatabaseConnection;
import com.charleseduardo.donation.donationsjavafx.dao.UserDAO;
import com.charleseduardo.donation.donationsjavafx.models.User;
import com.charleseduardo.donation.donationsjavafx.services.UserService;
import com.charleseduardo.donation.donationsjavafx.utils.ToolBox;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField emailLoginField;
    @FXML
    private PasswordField passwordLoginField;
    @FXML
    private Button loginButton;

    private UserService userService;
    private ToolBox toolBox = new ToolBox();

    public LoginController() {
        UserDAO userDAO = new UserDAO(DatabaseConnection.getConnection());
        this.userService = new UserService(userDAO);
    }

    @FXML
    private void handleLogin() throws SQLException {
        String email = emailLoginField.getText().trim();
        String password = passwordLoginField.getText().trim();

        if (email.isEmpty() || password.isEmpty()) {
            toolBox.showAlert("Error", "All fields are required!", Alert.AlertType.ERROR);
            return;
        }

        User user = userService.getUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            toolBox.showAlert("Success", "Login successful! Redirecting...", Alert.AlertType.INFORMATION);
        } else {
            toolBox.showAlert("Error", "Invalid credentials! Please try again.", Alert.AlertType.ERROR);
        }
    }
}

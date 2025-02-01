package com.charleseduardo.donation.donationsjavafx.controllers;

import com.charleseduardo.donation.donationsjavafx.dao.DatabaseConnection;
import com.charleseduardo.donation.donationsjavafx.dao.UserDAO;
import com.charleseduardo.donation.donationsjavafx.models.User;
import com.charleseduardo.donation.donationsjavafx.services.UserService;
import com.charleseduardo.donation.donationsjavafx.utils.ScreenManager;
import com.charleseduardo.donation.donationsjavafx.utils.ToolBox;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class RegisterController {

    @FXML
    private TextField nameRegisterField;
    @FXML
    private TextField emailRegisterField;
    @FXML
    private PasswordField passwordRegisterField;
    @FXML
    private PasswordField repeatPasswordRegisterField;

    @FXML
    private Button handleRegisterButton;

    private UserService userService;

    private ToolBox toolBox = new ToolBox();

    public RegisterController() {
        UserDAO userDAO = new UserDAO(DatabaseConnection.getConnection());
        this.userService = new UserService(userDAO);
    }

    @FXML
    private void handleLoginRedirect() {
        ScreenManager.redirectTo("login.fxml"); // Chama a troca de tela
    }

    @FXML
    private void handleRegister() {
        String fullName = nameRegisterField.getText();
        String email = emailRegisterField.getText();
        String password = passwordRegisterField.getText();
        String repeatPassword = repeatPasswordRegisterField.getText();

        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
            toolBox.showAlert("Error", "All fields is required!", Alert.AlertType.ERROR);
            return;
        }

        if (!password.equals(repeatPassword)) {
            toolBox.showAlert("Error", "The passwords are not the same!", Alert.AlertType.ERROR);
            return;
        }

        User newUser = new User();
        newUser.setFullName(fullName);
        newUser.setEmail(email);
        newUser.setPassword(password);

        try {
            userService.addUser(newUser);
            toolBox.showAlert("Success", "User registered successfully! Redirecting to login.", Alert.AlertType.INFORMATION);
            handleLoginRedirect();
        } catch (SQLException e) {
            if (e.getMessage().contains("Email already exists!")) {
                toolBox.showAlert("Error", "This email is already registered!", Alert.AlertType.ERROR);
            } else {
                toolBox.showAlert("Error", "Failed to register user!", Alert.AlertType.ERROR);
                e.printStackTrace();
            }
        }
    }

}

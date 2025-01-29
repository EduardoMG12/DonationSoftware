package com.charleseduardo.donation.donationsjavafx.controllers;

import com.charleseduardo.donation.donationsjavafx.models.User;
import com.charleseduardo.donation.donationsjavafx.services.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class RegisterController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField repeatPasswordField;

    private UserService userService;

//    public RegisterController() {
//        this.userService = new UserService();
//    }

    @FXML
    private void handleRegister() {
        String fullName = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String repeatPassword = repeatPasswordField.getText();

        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
            showAlert("Erro", "Todos os campos são obrigatórios!", Alert.AlertType.ERROR);
            return;
        }

        if (!password.equals(repeatPassword)) {
            showAlert("Erro", "As senhas não coincidem!", Alert.AlertType.ERROR);
            return;
        }

        User newUser = new User();
        newUser.setFullName(fullName);
        newUser.setEmail(email);
        newUser.setPassword(password);

        try {
            userService.addUser(newUser);
            showAlert("Sucesso", "Usuário registrado com sucesso!", Alert.AlertType.INFORMATION);
        } catch (SQLException e) {
            showAlert("Erro", "Falha ao registrar o usuário!", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

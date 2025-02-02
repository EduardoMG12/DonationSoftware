package com.charleseduardo.donation.donationsjavafx.controllers;

import com.charleseduardo.donation.donationsjavafx.utils.ScreenManager;
import com.charleseduardo.donation.donationsjavafx.utils.SessionManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HomeController {

    @FXML
    private TableView<?> donationsTable;

    @FXML
    private TableColumn<?, String> userColumn;

    @FXML
    private TableColumn<?, Double> amountColumn;

    @FXML
    private Button donateButton;

    @FXML
    private Button logoutButton;

    @FXML
    public void initialize() {
        System.out.println("Succes loading home screen!");

        userColumn.setText("User");
        amountColumn.setText("Donate value");
    }

    @FXML
    private void handleDonateButton() {
        ScreenManager.redirectTo("donation.fxml");
    }

    @FXML
    private void handleLogoutButton() {
        SessionManager.logout();
        ScreenManager.redirectTo("login.fxml");
    }
}

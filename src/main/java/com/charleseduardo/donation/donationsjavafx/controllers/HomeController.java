package com.charleseduardo.donation.donationsjavafx.controllers;

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
        System.out.println("Tela Home carregada com sucesso!");

        userColumn.setText("Usuário");
        amountColumn.setText("Valor Doado");
    }

    @FXML
    private void handleDonateButton() {
        System.out.println("Botão Fazer Doação clicado!");
    }

    @FXML
    private void handleLogoutButton() {
        System.out.println("Botão Deslogar clicado!");
    }
}

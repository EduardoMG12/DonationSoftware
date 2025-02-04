package com.charleseduardo.donation.donationsjavafx.controllers;

import com.charleseduardo.donation.donationsjavafx.dao.DatabaseConnection;
import com.charleseduardo.donation.donationsjavafx.dao.DonationDAO;
import com.charleseduardo.donation.donationsjavafx.models.Donation;
import com.charleseduardo.donation.donationsjavafx.services.DonationService;
import com.charleseduardo.donation.donationsjavafx.utils.ScreenManager;
import com.charleseduardo.donation.donationsjavafx.utils.SessionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.SQLException;
import java.util.List;

public class HomeController {

    @FXML
    private TableView<Donation> donationsTable;

    @FXML
    private TableColumn<Donation, String> userColumn;

    @FXML
    private TableColumn<Donation, Double> amountColumn;

    @FXML
    private Button donateButton;

    @FXML
    private Button logoutButton;

    private final DonationService donationService;
    private final DonationDAO donationDAO;

    public HomeController() {
        donationDAO = new DonationDAO(DatabaseConnection.getConnection());
        this.donationService = new DonationService(donationDAO);
    }


    @FXML
    public void initialize() {
        System.out.println("Succes loading home screen!");

        userColumn.setText("User");
        amountColumn.setText("Donate value");

        userColumn.setCellValueFactory(cellData -> cellData.getValue().getUserNameProperty());
        amountColumn.setCellValueFactory(cellData -> cellData.getValue().getAmountProperty().asObject());

        loadDonations();
    }

    private void loadDonations() {
        try {
            List<Donation> donations = donationService.getAllDonations();

            ObservableList<Donation> donationsList = FXCollections.observableArrayList(donations);

            donationsTable.setItems(donationsList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
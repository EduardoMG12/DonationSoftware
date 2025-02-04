package com.charleseduardo.donation.donationsjavafx.controllers;

import com.charleseduardo.donation.donationsjavafx.dao.DatabaseConnection;
import com.charleseduardo.donation.donationsjavafx.dao.DonationDAO;
import com.charleseduardo.donation.donationsjavafx.models.Donation;
import com.charleseduardo.donation.donationsjavafx.services.DonationService;
import com.charleseduardo.donation.donationsjavafx.utils.ScreenManager;
import com.charleseduardo.donation.donationsjavafx.utils.SessionManager;
import com.charleseduardo.donation.donationsjavafx.utils.ToolBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class DonationController {

    @FXML
    private TextField amountField;

    @FXML
    private Button donateButton;

    @FXML
    private Button backButton;

    private final DonationService donationService;
    private final DonationDAO donationDAO;

    private final ToolBox toolBox = new ToolBox();

    private int paymentMethodId = -1;

    public DonationController() {
        donationDAO = new DonationDAO(DatabaseConnection.getConnection());
        this.donationService = new DonationService(donationDAO);
    }

    @FXML
    private void initialize() {
        System.out.println("Donation screen loaded successfully!");
    }

    @FXML
    public void handlePaymentMethodSelection(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String methodName = clickedButton.getId();

        try {
            int methodId = donationDAO.getPaymentMethodIdByName(methodName);
            if (methodId != -1) {
                this.paymentMethodId = methodId;
                System.out.println("Selected payment method: " + methodName + " (ID: " + methodId + ")");
            } else {
                toolBox.showAlert("Error", "Payment method not found!", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            toolBox.showAlert("Error", "Database error: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleDonate() {
        try {
            int userId = SessionManager.getUserId();

            if (userId == -1) {
                toolBox.showAlert("Error", "You need to log in to donate.", Alert.AlertType.ERROR);
                return;
            }

            String amountText = amountField.getText().trim();
            if (amountText.isEmpty() || !amountText.matches("\\d+(\\.\\d{1,2})?")) {
                toolBox.showAlert("Error", "Please enter a valid numeric amount.", Alert.AlertType.ERROR);
                return;
            }

            double amount;

            try{
                amount = Double.parseDouble(amountText);
            } catch (NumberFormatException e) {
                toolBox.showAlert("Error", "Invalid amount. Please enter a valid number.", Alert.AlertType.ERROR);
                return;
            }

            if (amount <= 0) {
                toolBox.showAlert("Error", "Amount must be greater than zero.", Alert.AlertType.ERROR);
                return;
            }

            if (paymentMethodId == -1) {
                toolBox.showAlert("Error", "Please select a payment method.", Alert.AlertType.ERROR);
                return;
            }

            Donation donation = new Donation(userId, paymentMethodId, amount);
            donationService.addDonation(donation);

            toolBox.showAlert("Success", "Donation successful!", Alert.AlertType.INFORMATION);
            amountField.clear();
        } catch (NumberFormatException e) {
            toolBox.showAlert("Error", "Invalid amount. Please enter a number.", Alert.AlertType.ERROR);
        } catch (SQLException e) {
            toolBox.showAlert("Error", "Database error: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleBackButton() {
        ScreenManager.redirectTo("home.fxml");
    }

    @FXML
    private void handleLogoutButton() {
        SessionManager.logout();
        ScreenManager.redirectTo("login.fxml");
    }
}
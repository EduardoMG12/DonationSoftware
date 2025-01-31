package com.charleseduardo.donation.donationsjavafx.utils;

import javafx.scene.control.Alert;

public class ToolBox {

    public void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}

package com.charleseduardo.donation.donationsjavafx.dao;

import com.charleseduardo.donation.donationsjavafx.models.Donation;
import com.charleseduardo.donation.donationsjavafx.utils.ScreenManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonationDAO {
    private Connection connection;

    public DonationDAO(Connection connection) {
        this.connection = connection;
    }

    public void addDonation(Donation donation) throws SQLException {
        String sql = "INSERT INTO donations (user_id, amount, payment_method_id, donation_date) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, donation.getUserId());
            stmt.setDouble(2, donation.getAmount());
            stmt.setInt(3, donation.getPaymentMethodId());
            stmt.setTimestamp(4, Timestamp.valueOf(donation.getDonationDate()));

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Failed to insert donation, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    donation.setId(generatedKeys.getInt(1));
                    ScreenManager.redirectTo("home.fxml");
                } else {
                    throw new SQLException("Failed to retrieve donation ID.");
                }
            }
        }
    }

    public List<Donation> findAllDonations() throws SQLException {
        List<Donation> donations = new ArrayList<>();
        String sql = "SELECT d.*, u.full_name FROM donations d " +
                "JOIN users u ON d.user_id = u.id " +
                "ORDER BY d.amount DESC";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Donation donation = new Donation(
                        rs.getInt("user_id"),
                        rs.getInt("payment_method_id"),
                        rs.getDouble("amount"),
                        rs.getString("full_name")
                );
                donation.setId(rs.getInt("id"));
                donation.setDonationDate(rs.getTimestamp("donation_date").toLocalDateTime());

                donations.add(donation);
            }
        }
        return donations;
    }



    public int getPaymentMethodIdByName(String methodName) throws SQLException {
        String sql = "SELECT id FROM payment_methods WHERE name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, methodName);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        }
        return -1;
    }
}

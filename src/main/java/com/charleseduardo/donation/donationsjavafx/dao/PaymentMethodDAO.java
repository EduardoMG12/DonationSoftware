package com.charleseduardo.donation.donationsjavafx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentMethodDAO {
    private Connection connection;

    public PaymentMethodDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean paymentMethodExists(int paymentMethodId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM payment_methods WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, paymentMethodId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }
}

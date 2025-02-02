package com.charleseduardo.donation.donationsjavafx.services;

import com.charleseduardo.donation.donationsjavafx.dao.DatabaseConnection;
import com.charleseduardo.donation.donationsjavafx.dao.DonationDAO;
import com.charleseduardo.donation.donationsjavafx.dao.PaymentMethodDAO;
import com.charleseduardo.donation.donationsjavafx.models.Donation;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class DonationService {
    private DonationDAO donationDAO;

    public DonationService(DonationDAO donationDAO) {
        this.donationDAO = donationDAO;
    }

    public void addDonation(Donation donation) throws SQLException {

        if (donation.getAmount() <= 0) {
            throw new IllegalArgumentException("Donation amount must be greater than zero.");
        }

        PaymentMethodDAO paymentMethodDAO = new PaymentMethodDAO(DatabaseConnection.getConnection());
        if (donation.getPaymentMethodId() < 0 || !paymentMethodDAO.paymentMethodExists(donation.getPaymentMethodId())) {
            throw new IllegalArgumentException("Invalid payment method.");
        }

        if (donation.getDonationDate() != null && donation.getDonationDate().isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Donation date cannot be in the future.");
        }

        donationDAO.addDonation(donation);
    }
}

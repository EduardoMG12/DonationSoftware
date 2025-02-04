package com.charleseduardo.donation.donationsjavafx.services;

import com.charleseduardo.donation.donationsjavafx.dao.DatabaseConnection;
import com.charleseduardo.donation.donationsjavafx.dao.DonationDAO;
import com.charleseduardo.donation.donationsjavafx.dao.PaymentMethodDAO;
import com.charleseduardo.donation.donationsjavafx.models.Donation;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class DonationService {
    private DonationDAO donationDAO;

    public DonationService(DonationDAO donationDAO) {
        this.donationDAO = donationDAO;
    }

    public void addDonation(Donation donation) throws SQLException {
        if (donation.getAmount() <= 0) {
            throw new IllegalArgumentException("Donation amount must be greater than zero.");
        }

        if (donation.getDonationDate() == null) {
            donation.setDonationDate(LocalDateTime.now());
        }

        donationDAO.addDonation(donation);
    }

    public List<Donation> getAllDonations() throws SQLException {
        return donationDAO.findAllDonations();
    }
}

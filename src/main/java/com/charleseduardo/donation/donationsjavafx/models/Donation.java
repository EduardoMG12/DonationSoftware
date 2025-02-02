package com.charleseduardo.donation.donationsjavafx.models;

import java.time.LocalDateTime;

public class Donation {
    private int id;
    private int userId;
    private double amount;
    private int paymentMethodId;
    private LocalDateTime donationDate;

    public Donation() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public LocalDateTime getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDateTime donationDate) {
        this.donationDate = donationDate;
    }

    public Donation(int id, int userId, double amount, int paymentMethodId, LocalDateTime donationDate) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.paymentMethodId = paymentMethodId;
        this.donationDate = donationDate;
    }
}

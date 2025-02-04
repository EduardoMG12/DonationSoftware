package com.charleseduardo.donation.donationsjavafx.models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;

public class Donation {
    private int id;
    private String userName;
    private int userId;
    private double amount;
    private int paymentMethodId;
    private LocalDateTime donationDate;

    public Donation(int userId, int paymentMethodId, double amount) {
        this.userId = userId;
        this.paymentMethodId = paymentMethodId;
        this.amount = amount;
    }

    public Donation(int userId, int paymentMethodId, double amount, String userName) {
        this.userId = userId;
        this.paymentMethodId = paymentMethodId;
        this.amount = amount;
        this.userName = userName;
        this.userNameProperty = new SimpleStringProperty(userName);
        this.amountProperty = new SimpleDoubleProperty(amount);
    }

    private StringProperty userNameProperty;
    private DoubleProperty amountProperty;

    public StringProperty getUserNameProperty() {
        return userNameProperty;
    }

    public DoubleProperty getAmountProperty() {
        return amountProperty;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

package com.charleseduardo.donation.donationsjavafx.models;

import java.time.LocalDateTime;

public class User {
    private int id;
    private String fullName;
    private int yearsOld;
    private String email;
    private String password;
    private LocalDateTime createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User() {}

    public User(int id, String fullName, int yearsOld, String email, String password, LocalDateTime createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.yearsOld = yearsOld;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }
}

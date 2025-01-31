package com.charleseduardo.donation.donationsjavafx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/DB_donation_tracker";
    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static Connection cachedConnection;

    public static Connection getConnection() {
        try{
            if(cachedConnection == null){
                cachedConnection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
            return cachedConnection;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

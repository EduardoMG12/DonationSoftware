package com.charleseduardo.donation.donationsjavafx.tests;

import com.charleseduardo.donation.donationsjavafx.dao.UserDAO;
import com.charleseduardo.donation.donationsjavafx.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DatabaseTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/DB_donation_tracker";
        String user = "user";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("success connection!");

            UserDAO userDAO = new UserDAO(connection);
            List<User> users = userDAO.getAllUsers();

            System.out.println("find user:");
            for (User userObj : users) {
                System.out.println("ID: " + userObj.getId() +
                        ", Name: " + userObj.getFullName() +
                        ", Email: " + userObj.getEmail());
            }
        } catch (SQLException e) {
            System.err.println("Error to connect database or execute query:");
            e.printStackTrace();
        }
    }
}
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
            System.out.println("Conexão bem-sucedida!");

            // Testar o DAO
            UserDAO userDAO = new UserDAO(connection);
            List<User> users = userDAO.getAllUsers();

            // Exibir os usuários recuperados
            System.out.println("Usuários encontrados:");
            for (User userObj : users) {
                System.out.println("ID: " + userObj.getId() +
                        ", Nome: " + userObj.getFullName() +
                        ", Email: " + userObj.getEmail());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco ou executar a consulta:");
            e.printStackTrace();
        }
    }
}
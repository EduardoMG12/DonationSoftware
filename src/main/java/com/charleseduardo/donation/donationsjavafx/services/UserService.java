package com.charleseduardo.donation.donationsjavafx.services;

import com.charleseduardo.donation.donationsjavafx.dao.DatabaseConnection;
import com.charleseduardo.donation.donationsjavafx.dao.PaymentMethodDAO;
import com.charleseduardo.donation.donationsjavafx.dao.UserDAO;
import com.charleseduardo.donation.donationsjavafx.models.Donation;
import com.charleseduardo.donation.donationsjavafx.models.User;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User getUserByEmail(String email) throws SQLException {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("The email field is required.");
        }
        return userDAO.findByEmail(email);
    }


    public List<User> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }

    public void addUser(User user) throws SQLException {
        if (user.getFullName() == null || user.getFullName().isEmpty()) {
            throw new IllegalArgumentException("the fullname field is required.");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("The email field is required.");
        }
        if (user.getPassword() == null || user.getPassword().length() < 6) {
            throw new IllegalArgumentException("The password must be at least 6 characters long.");
        }
        if (userDAO.emailExists(user.getEmail())) {
            throw new SQLException("Email already exists!");
        }
        userDAO.addUser(user);
    }

    public User getUserById(int id) throws SQLException {
        return userDAO.getUserById(id);
    }

    public void updateUser(User user) throws SQLException {
        if (user.getId() <= 0) {
            throw new IllegalArgumentException("User id not found.");
        }
        userDAO.updateUser(user);
    }

    public void deleteUser(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid id.");
        }
        userDAO.deleteUser(id);
    }
}

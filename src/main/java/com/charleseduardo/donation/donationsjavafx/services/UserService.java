package com.charleseduardo.donation.donationsjavafx.services;

import com.charleseduardo.donation.donationsjavafx.dao.UserDAO;
import com.charleseduardo.donation.donationsjavafx.models.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }

    public void addUser(User user) throws SQLException {
        if (user.getFullName() == null || user.getFullName().isEmpty()) {
            throw new IllegalArgumentException("O nome completo é obrigatório.");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("O email é obrigatório.");
        }
        if (user.getPassword() == null || user.getPassword().length() < 6) {
            throw new IllegalArgumentException("A senha deve ter pelo menos 6 caracteres.");
        }
        userDAO.addUser(user);
    }

    public User getUserById(int id) throws SQLException {
        return userDAO.getUserById(id);
    }

    public void updateUser(User user) throws SQLException {
        if (user.getId() <= 0) {
            throw new IllegalArgumentException("ID do usuário inválido.");
        }
        userDAO.updateUser(user);
    }

    public void deleteUser(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }
        userDAO.deleteUser(id);
    }
}

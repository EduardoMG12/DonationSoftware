package com.charleseduardo.donation.donationsjavafx.utils;

import com.charleseduardo.donation.donationsjavafx.models.User;

public class SessionManager {
    private static User loggedInUser;

    public static void setLoggedInUser(User user) {
        loggedInUser = user;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static int getUserId() {
        return (loggedInUser != null) ? loggedInUser.getId() : -1;
    }

    public static void logout() {
        loggedInUser = null;
    }
}

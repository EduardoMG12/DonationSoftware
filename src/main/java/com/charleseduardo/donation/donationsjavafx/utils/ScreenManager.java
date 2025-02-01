package com.charleseduardo.donation.donationsjavafx.utils;

import com.charleseduardo.donation.donationsjavafx.MainApp;
import java.io.IOException;

public class ScreenManager {
    public static void redirectTo(String fxmlPath) {
        try {
            MainApp.changeScreen(fxmlPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

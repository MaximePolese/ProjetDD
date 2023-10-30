package main;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Menu mainPage = new Menu();
        try {
            mainPage.launchMenu();
        } catch (SQLException sql1) {
            System.out.println(sql1.getMessage());
        }
    }
}

package main;

import java.sql.*;

public class dbConnection {
    private static final dbConnection instance = new dbConnection();
    private static Connection mydb;

    public static dbConnection getInstance() {
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (mydb == null) {
            Driver myDriver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(myDriver);
            String URL = "jdbc:mysql://localhost:3306/mydb_java";
            mydb = DriverManager.getConnection(URL, "root", "root");

        }
        return mydb;
    }
}
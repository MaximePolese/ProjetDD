package main;

import java.sql.*;

public class DbConnection {
    private static final DbConnection instance = new DbConnection();
    private static Connection mydb;

    public static DbConnection getInstance() {
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
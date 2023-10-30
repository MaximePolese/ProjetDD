package main;

import personnage.Personnage;

import java.sql.*;
import java.math.*;

public class BDD_CRUD {
    private Connection mydb;

    public BDD_CRUD() {
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(myDriver);
            String URL = "jdbc:mysql://localhost:3306/mydb_java";
            this.mydb = DriverManager.getConnection(URL, "root",
                    "root");
        } catch (SQLException e) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
    }

    public void getHeroes() {
    }

    public void createHero(Personnage hero) throws SQLException {
        PreparedStatement pstmt = mydb.prepareStatement("INSERT INTO hero (name, type, life, strength, offensiveItem, defensiveItem, playerPos) VALUES(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, hero.getName());
        pstmt.setString(2, hero.getType());
        pstmt.setInt(3, hero.getLife());
        pstmt.setInt(4, hero.getStrength());
        pstmt.setString(5, hero.getOffensiveItem().getWeaponName());
        pstmt.setString(6, hero.getDefensiveItem().getShieldName());
        pstmt.setInt(7, hero.getPlayerPos());
        pstmt.executeUpdate();
        ResultSet rs = pstmt.getGeneratedKeys();
        while(rs.next()) { // .next() pour les ResultSet permet de passer à la ligne suivante et donc d'itérer la table récupérée.
            System.out.println("id : " + rs.getInt(1)); //.getInt() permet de récupérer un int en lui donnant le label de la colonne.
        }
    }

    public void editHero() {
    }

    public void changeLifePoints() {
    }

}

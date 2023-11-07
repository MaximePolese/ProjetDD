package main;

import personnage.Personnage;

import java.sql.*;

public class BDD_CRUD {
    private dbConnection mydb;
    private ResultSet rs;
    private Statement stmt;

    public BDD_CRUD() {
        mydb = dbConnection.getInstance();
    }

    public void getHeroes() throws SQLException {
        stmt = mydb.getConnection().createStatement();
        rs = stmt.executeQuery("SELECT * FROM hero");
        while (rs.next()) {
            System.out.print("id : " + rs.getInt(1));
            System.out.print(", name : " + rs.getString(2));
            System.out.print(", type : " + rs.getString(3));
            System.out.print(", life: " + rs.getInt(4));
            System.out.print(", strength: " + rs.getInt(5));
            System.out.print(", offensiveItem : " + rs.getString(6));
            System.out.print(", defensiveItem : " + rs.getString(7));
            System.out.print(", playerPos : " + rs.getInt(8));
            System.out.println();
        }
    }

    public void createHero(Personnage hero) throws SQLException {
        PreparedStatement pstmt = mydb.getConnection().prepareStatement("INSERT INTO hero (name, type, life, strength, offensiveItem, defensiveItem, playerPos) VALUES(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, hero.getName());
        pstmt.setString(2, hero.getType());
        pstmt.setInt(3, hero.getLife());
        pstmt.setInt(4, hero.getStrength());
        pstmt.setString(5, hero.getOffensiveItem().getWeaponName());
        pstmt.setString(6, hero.getDefensiveItem().getShieldName());
        pstmt.setInt(7, hero.getPlayerPos());
        pstmt.executeUpdate();
        rs = pstmt.getGeneratedKeys();
        while (rs.next()) { // .next() pour les ResultSet permet de passer à la ligne suivante et donc d'itérer la table récupérée.
            hero.setId(rs.getInt(1));
        }
    }

    public void updatePlayer(Personnage hero) throws SQLException {
        PreparedStatement pstmt = mydb.getConnection().prepareStatement("UPDATE hero SET name = ?, type = ?, life = ?, strength = ?, offensiveItem = ?, defensiveItem = ?, playerPos = ? WHERE id = ?");
        pstmt.setString(1, hero.getName());
        pstmt.setString(2, hero.getType());
        pstmt.setInt(3, hero.getLife());
        pstmt.setInt(4, hero.getStrength());
        pstmt.setString(5, hero.getOffensiveItem().getWeaponName());
        pstmt.setString(6, hero.getDefensiveItem().getShieldName());
        pstmt.setInt(7, hero.getPlayerPos());
        pstmt.setInt(8, hero.getId());
        pstmt.executeUpdate();
    }
}
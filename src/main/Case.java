package main;

import personnage.*;

import java.sql.SQLException;

public interface Case {

    public GameState interaction(Personnage player) throws SQLException;

}

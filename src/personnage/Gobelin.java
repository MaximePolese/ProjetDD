package personnage;

import main.GameState;

import java.sql.SQLException;

public class Gobelin extends Ennemi {
    public Gobelin() {
        super("Gobelin");
        this.setLife(6);
        this.setStrength(1);
    }
    @Override
    public GameState interaction(Personnage player) throws SQLException {
        System.out.print("Gobelin");
        return super.interaction(player);
    }
}

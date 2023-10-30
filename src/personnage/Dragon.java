package personnage;

import main.GameState;

import java.sql.SQLException;

public class Dragon extends Ennemi {
    public Dragon() {
        super("Dragon");
        this.setLife(15);
        this.setStrength(4);
    }
    @Override
    public GameState interaction(Personnage player) throws SQLException {
        System.out.print("Dragon");
        return super.interaction(player);
    }
}

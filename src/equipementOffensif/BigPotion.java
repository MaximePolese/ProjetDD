package equipementOffensif;

import main.GameState;
import personnage.Personnage;

import java.sql.SQLException;

public class BigPotion extends Potion {

    public BigPotion() {
        super("Big potion");
        this.setHealth(5);
    }
    @Override
    public GameState interaction(Personnage player) throws SQLException {
        System.out.print("Big");
        super.interaction(player);
        return GameState.continu;
    }
}

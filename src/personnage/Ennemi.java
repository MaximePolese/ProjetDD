package personnage;

import main.*;

import java.sql.SQLException;

public abstract class Ennemi extends Personnage implements Case {
    protected Ennemi(String name) {
        super("ennemi", name);
    }

    @Override
    public GameState interaction(Personnage player) throws SQLException {
        System.out.println(" veut la BAGARRE !");
        return player.fight(this);
    }
}

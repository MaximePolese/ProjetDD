package personnage;

import main.Case;
import main.GameState;

public abstract class Ennemi extends Personnage implements Case {
    protected Ennemi(String name) {
        super("ennemi", name);
    }

    @Override
    public GameState interaction(Personnage player) {
        System.out.println(" veut la BAGARRE !");
        return player.fight(this);
    }
}

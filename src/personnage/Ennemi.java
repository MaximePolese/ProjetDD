package personnage;

import main.Case;
import main.Game;

public abstract class Ennemi extends Personnage implements Case {
    protected Ennemi(String name) {
        super("ennemi", name);
    }

    @Override
    public void interaction(Personnage player) {
        System.out.println(" veut la BAGARRE !");
        player.fight(this);
    }
}

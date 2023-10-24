package personnage;

import main.Case;

public abstract class Ennemi extends Personnage implements Case {
    protected Ennemi(String name) {
        super("ennemi", name);
    }

    @Override
    public void interaction(Personnage player) {
        System.out.println("enemies attack");
    }
}

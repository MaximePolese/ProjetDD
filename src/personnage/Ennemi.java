package personnage;

import main.Case;

public class Ennemi extends Personnage implements Case {
    public Ennemi(String name) {
        super("ennemi", name);
    }

    @Override
    public void interaction() {
        System.out.println("enemies attack");
    }
}

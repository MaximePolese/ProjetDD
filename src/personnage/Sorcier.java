package personnage;

import main.GameState;

public class Sorcier extends Ennemi {
    public Sorcier() {
        super("Sorcier");
        this.setLife(9);
        this.setStrength(2);
    }
    @Override
    public GameState interaction(Personnage player) {
        System.out.print("Sorcier");
        return super.interaction(player);
    }
}

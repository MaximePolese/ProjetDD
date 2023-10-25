package personnage;

import main.GameState;

public class Gobelin extends Ennemi {
    public Gobelin() {
        super("Gobelin");
        this.setLife(6);
        this.setStrength(1);
    }
    @Override
    public GameState interaction(Personnage player) {
        System.out.print("Gobelin");
        return super.interaction(player);
    }
}

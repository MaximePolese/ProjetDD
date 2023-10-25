package personnage;

import main.GameState;

public class Dragon extends Ennemi {
    public Dragon() {
        super("Dragon");
        this.setLife(15);
        this.setStrength(4);
    }
    @Override
    public GameState interaction(Personnage player) {
        System.out.print("Dragon");
        return super.interaction(player);
    }
}

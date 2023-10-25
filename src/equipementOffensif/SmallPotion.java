package equipementOffensif;

import main.GameState;
import personnage.Personnage;
import personnage.Warrior;

public class SmallPotion extends Potion {

    public SmallPotion() {
        super("Small potion");
        this.setHealth(2);
    }

    @Override
    public GameState interaction(Personnage player) {
        System.out.print("Small");
        return super.interaction(player);
    }
}
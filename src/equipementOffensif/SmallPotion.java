package equipementOffensif;

import personnage.Personnage;
import personnage.Warrior;

public class SmallPotion extends Potion {

    public SmallPotion() {
        super("Small potion");
        this.setHealth(2);
    }

    @Override
    public void interaction(Personnage player) {
        System.out.print("Small");
        super.interaction(player);
    }
}
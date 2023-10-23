package equipementOffensif;

import personnage.Personnage;

public class SmallPotion extends Potion {

    public SmallPotion() {
        super("Small potion");
        this.setHealth(2);
    }
    @Override
    public void interaction(Personnage player) {
        System.out.println("Small potion found");
    }
}
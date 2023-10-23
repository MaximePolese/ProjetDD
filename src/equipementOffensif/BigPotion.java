package equipementOffensif;

import personnage.Personnage;

public class BigPotion extends Potion {

    public BigPotion() {
        super("Big potion");
        this.setHealth(5);
    }
    @Override
    public void interaction(Personnage player) {
        System.out.println("Big potion found");
    }
}

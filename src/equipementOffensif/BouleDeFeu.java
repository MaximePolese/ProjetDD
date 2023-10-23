package equipementOffensif;

import personnage.Personnage;

public class BouleDeFeu extends Spell {

    public BouleDeFeu() {
        super("Boule de feu");
        this.setWeaponAttack(7);
    }
    @Override
    public void interaction(Personnage player) {
        System.out.println("Boule de feu found");
    }
}

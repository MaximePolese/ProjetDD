package equipementOffensif;

import personnage.Personnage;

public class Eclair extends Spell {

    public Eclair() {
        super("Eclair");
        this.setWeaponAttack(2);
    }
    @Override
    public void interaction(Personnage player) {
        System.out.println("Eclair found");
    }
}

package equipementOffensif;

import personnage.Personnage;

public class Epee extends Weapon {
    public Epee() {
        super("Epee");
        this.setWeaponAttack(5);
    }
    @Override
    public void interaction(Personnage player) {
        System.out.println("Epee found");
    }
}

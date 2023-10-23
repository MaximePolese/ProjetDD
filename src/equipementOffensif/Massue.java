package equipementOffensif;

import personnage.Personnage;

public class Massue extends Weapon {
    public Massue() {
        super("Massue");
        this.setWeaponAttack(3);
    }
    @Override
    public void interaction(Personnage player) {
        System.out.println("Massue found");
    }
}

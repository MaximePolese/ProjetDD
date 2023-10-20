package personnage;

import equipementDefensif.Shield;
import equipementOffensif.Weapon;

public class Warrior extends Personnage {
    public Warrior(String type, String name) {
        super(type, name);
        this.setPlayerPos(1);
        this.setLife(10);
        this.setStrength(10);
//        this.setOffensiveItem(new Weapon("Epée"));
//        this.setDefensiveItem(new Shield("Bouclier d'acier"));
    }
}


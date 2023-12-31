package personnage;

import equipementDefensif.*;
import equipementOffensif.MainsNues;
import main.BDD_CRUD;

public class Warrior extends Personnage {
    public Warrior(String type, String name) {
        super(type, name);
        this.setLife(5);
        this.setStrength(5);
        this.setMaxLife(10);
        this.setOffensiveItem(new MainsNues());
        this.getOffensiveItem().setWeaponType("arme");
        this.setDefensiveItem(new Shield());
    }
}


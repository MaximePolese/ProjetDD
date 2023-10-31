package personnage;

import equipementDefensif.*;
import equipementOffensif.MainsNues;
import main.BDD_CRUD;

public class Wizard extends Personnage {
    public Wizard(String type, String name, BDD_CRUD db) {
        super(type, name, db);
        this.setLife(3);
        this.setStrength(8);
        this.setMaxLife(6);
        this.setOffensiveItem(new MainsNues());
        this.getOffensiveItem().setWeaponType("sort");
        this.setDefensiveItem(new Philtre());
    }
}

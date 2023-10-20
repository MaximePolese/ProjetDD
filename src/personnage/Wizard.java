package personnage;

import equipementDefensif.Potion;
import equipementOffensif.Spell;

public class Wizard extends Personnage {
    public Wizard(String type,String name) {
        super(type, name);
        this.setPlayerPos(1);
        this.setLife(6);
        this.setStrength(15);
        this.setOffensiveItem(new Spell("sort"));
        this.setDefensiveItem(new Potion("Barrière d'Ether"));
    }
}

package personnage;

import equipementDefensif.Philtre;
import equipementOffensif.Spell;

public class Wizard extends Personnage {
    public Wizard(String type, String name) {
        super(type, name);
//        this.setPlayerPos(1);
        this.setLife(3);
        this.setStrength(8);
//        this.setOffensiveItem(new Spell("sort"));
//        this.setDefensiveItem(new Philtre("Philtre d'Ether"));
    }
}

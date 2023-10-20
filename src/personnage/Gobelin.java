package personnage;

import main.Case;

public class Gobelin extends Personnage implements Case {
    public Gobelin(String type, String name) {
        super(type, name);
        this.setLife(6);
        this.setStrength(1);
    }
}

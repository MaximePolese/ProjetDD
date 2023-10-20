package personnage;
import main.Case;
public class Sorcier extends Personnage implements Case {
    public Sorcier(String type, String name) {
        super(type, name);
        this.setLife(9);
        this.setStrength(2);
    }
}

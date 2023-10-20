package personnage;
import main.Case;
public class Dragon extends Personnage implements Case {
    public Dragon(String type, String name) {
        super(type, name);
        this.setLife(15);
        this.setStrength(4);
    }
}

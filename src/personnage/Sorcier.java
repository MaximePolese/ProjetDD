package personnage;

public class Sorcier extends Personnage {
    public Sorcier(String type, String name) {
        super(type, name);
        this.setPlayerPos(1);
        this.setLife(9);
        this.setStrength(2);
    }
}

package personnage;

public class Gobelin extends Personnage {
    public Gobelin(String type, String name) {
        super(type, name);
        this.setPlayerPos(1);
        this.setLife(6);
        this.setStrength(1);
    }
}

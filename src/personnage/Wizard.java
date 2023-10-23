package personnage;

public class Wizard extends Personnage {
    public Wizard(String type, String name) {
        super(type, name);
        this.setLife(3);
        this.setStrength(8);
        //        this.setPlayerPos(1);
    }
}

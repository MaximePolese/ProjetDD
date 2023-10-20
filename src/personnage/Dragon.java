package personnage;

public class Dragon extends Personnage {
    public Dragon(String type, String name) {
        super(type, name);
        this.setPlayerPos(1);
        this.setLife(15);
        this.setStrength(4);
    }
}

package personnage;

public class Warrior extends Personnage {
    public Warrior(String type, String name) {
        super(type, name);
        this.setLife(5);
        this.setStrength(5);
//        this.setPlayerPos(1);
    }
}


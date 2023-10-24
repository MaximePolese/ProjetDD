package personnage;

public class Sorcier extends Ennemi {
    public Sorcier() {
        super("Sorcier");
        this.setLife(9);
        this.setStrength(2);
    }
    @Override
    public void interaction(Personnage player) {
        System.out.print("Sorcier");
        super.interaction(player);
    }
}

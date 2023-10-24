package personnage;

public class Gobelin extends Ennemi {
    public Gobelin() {
        super("Gobelin");
        this.setLife(6);
        this.setStrength(1);
    }
    @Override
    public void interaction(Personnage player) {
        System.out.print("Gobelin");
        super.interaction(player);
    }
}

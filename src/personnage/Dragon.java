package personnage;

public class Dragon extends Ennemi {
    public Dragon() {
        super("Dragon");
        this.setLife(15);
        this.setStrength(4);
    }
    @Override
    public void interaction(Personnage player) {
        System.out.print("Dragon");
        super.interaction(player);
    }
}

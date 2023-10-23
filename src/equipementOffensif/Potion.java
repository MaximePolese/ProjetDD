package equipementOffensif;

import personnage.Personnage;

public abstract class Potion extends EquipementOffensif {
    private int health;

    protected Potion(String name) {
        super(name);
    }

    @Override
    public String getWeaponType() {
        return "potion";
    }

    @Override
    public String toString() {
        return "Potion{" +
                "health=" + health +
                '}';
    }

    @Override
    public void interaction(Personnage player) {
        System.out.println(" potion found");
        player.heals(this);
        System.out.println("new player's life : " + player.getLife());
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
}

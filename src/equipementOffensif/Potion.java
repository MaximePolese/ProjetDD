package equipementOffensif;

import main.GameState;
import personnage.Personnage;

import java.sql.SQLException;

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
        return "Potion {" +
                "health = " + health +
                '}';
    }

    @Override
    public GameState interaction(Personnage player) throws SQLException {
        System.out.println(" potion found");
        player.heals(this);
        return GameState.continu;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
}

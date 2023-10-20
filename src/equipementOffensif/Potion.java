package equipementOffensif;

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

    public void setHealth(int health) {
        this.health = health;
    }
}

package equipementOffensif;

public abstract class Potion extends EquipementOffensif {

    protected Potion(String name) {
        super(name);
    }

    @Override
    public String getWeaponType() {
        return "potion";
    }
}

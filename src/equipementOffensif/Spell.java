package equipementOffensif;

public abstract class Spell extends EquipementOffensif {

    protected Spell(String name) {
        super(name);
        this.setWeaponType("sort");
    }
}

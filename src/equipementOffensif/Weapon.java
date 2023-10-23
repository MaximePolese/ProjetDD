package equipementOffensif;

public abstract class Weapon extends EquipementOffensif {

    protected Weapon(String name) {
        super(name);
        this.setWeaponType("arme");
    }
}

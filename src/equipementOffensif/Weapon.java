package equipementOffensif;

public class Weapon extends EquipementOffensif {

    public Weapon(String name) {
        super(name);
        this.setWeaponAttack(3);
    }

    @Override
    public String getWeaponType() {
        return "arme";
    }
}

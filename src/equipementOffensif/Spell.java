package equipementOffensif;

public class Spell extends EquipementOffensif {

    public Spell(String name) {
        super(name);
        this.setWeaponAttack(5);
    }

    @Override
    public String getWeaponType() {
        return "sort";
    }
}

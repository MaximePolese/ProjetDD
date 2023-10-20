package equipementOffensif;

public class Spell extends EquipementOffensif {

    public Spell(String type) {
        this.setWeaponType(type);
        this.setWeaponName("Flamme");
        this.setWeaponAttack(5);
    }
}

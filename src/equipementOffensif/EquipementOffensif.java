package equipementOffensif;
import main.Case;
import main.GameState;
import personnage.Personnage;

public abstract class EquipementOffensif implements Case {
    private String weaponName;
    private int weaponAttack;
    private String weaponType;

    protected EquipementOffensif(String name) {
        this.weaponName = name;
    }

    @Override
    public String toString() {
        return "EquipementOffensif {" +
                "weaponType = " + weaponType +
                ", weaponName = " + weaponName +
                ", weaponAttack = " + weaponAttack +
                '}';
    }
    @Override
    public GameState interaction(Personnage player) {
        System.out.println("weapon found");
        player.newItem(this);
        return GameState.continu;
    }
    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getWeaponAttack() {
        return weaponAttack;
    }

    public void setWeaponAttack(int weaponAttack) {
        this.weaponAttack = weaponAttack;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public String getWeaponType() {
        return weaponType;
    }
}

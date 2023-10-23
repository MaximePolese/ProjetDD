package equipementOffensif;
import main.Case;
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
        return "EquipementOffensif{" +
                "weaponType='" + getWeaponType() + '\'' +
                ", weaponName='" + weaponName + '\'' +
                ", weaponAttack=" + weaponAttack +
                '}';
    }
    @Override
    public void interaction(Personnage player) {
        System.out.println("weapon found");
        player.newItem(this);
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

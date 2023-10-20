package equipementOffensif;

public abstract class EquipementOffensif {
    private String weaponName;
    private int weaponAttack;

    public EquipementOffensif(String name) {
        this.weaponName = name;
    }

    public abstract String getWeaponType();

    @Override
    public String toString() {
        return "EquipementOffensif{" +
                "weaponType='" + getWeaponType() + '\'' +
                ", weaponName='" + weaponName + '\'' +
                ", weaponAttack=" + weaponAttack +
                '}';
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
}

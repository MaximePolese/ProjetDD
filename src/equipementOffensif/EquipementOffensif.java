package equipementOffensif;

public abstract class EquipementOffensif {
    private String weaponType;
    private String weaponName;
    private int weaponAttack;

    @Override
    public String toString() {
        return "EquipementOffensif{" +
                "weaponType='" + weaponType + '\'' +
                ", weaponName='" + weaponName + '\'' +
                ", weaponAttack=" + weaponAttack +
                '}';
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
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

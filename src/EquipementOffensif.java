public class EquipementOffensif {
    private String weapon;
    private String weaponName;
    private int weaponAttack;

    public EquipementOffensif(String type) {
        this.weapon = type;
        if (this.weapon.equals("arme")) {
            this.weaponName = "Epée";
            this.weaponAttack = 3;
        } else if (this.weapon.equals("sort")) {
            this.weaponName = "Flamme des dieux";
            this.weaponAttack = 5;
        }
    }

    @Override
    public String toString() {
        return "EquipementOffensif{" +
                "weapon='" + weapon + '\'' +
                ", weaponName='" + weaponName + '\'' +
                ", weaponAttack=" + weaponAttack +
                '}';
    }
}

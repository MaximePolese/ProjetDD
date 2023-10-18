public class EquipementDefensif {
    private String shield;
    private String shieldName;
    private int shieldResistance;

    public EquipementDefensif(String type) {
        this.shield = type;
        if (this.shield.equals("bouclier")) {
            this.shieldName = "Broquel";
            this.shieldResistance = 3;
        } else if (this.shield.equals("philtre")) {
            this.shieldName = "Barrière d'Ether";
            this.shieldResistance = 4;
        }
    }

    @Override
    public String toString() {
        return "EquipementDefensif{" +
                "shield='" + shield + '\'' +
                ", shieldName='" + shieldName + '\'' +
                ", shieldResistance=" + shieldResistance +
                '}';
    }
}

package equipementDefensif;

public abstract class EquipementDefensif {
    private String shieldType;
    private String shieldName;
    private int shieldResistance;

    @Override
    public String toString() {
        return "EquipementDefensif{" +
                "shieldType='" + shieldType + '\'' +
                ", shieldName='" + shieldName + '\'' +
                ", shieldResistance=" + shieldResistance +
                '}';
    }

    public String getShieldType() {
        return shieldType;
    }

    public void setShieldType(String shieldType) {
        this.shieldType = shieldType;
    }

    public String getShieldName() {
        return shieldName;
    }

    public void setShieldName(String shieldName) {
        this.shieldName = shieldName;
    }

    public int getShieldResistance() {
        return shieldResistance;
    }

    public void setShieldResistance(int shieldResistance) {
        this.shieldResistance = shieldResistance;
    }
}
